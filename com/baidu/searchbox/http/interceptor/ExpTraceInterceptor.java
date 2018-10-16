package com.baidu.searchbox.http.interceptor;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExpTraceInterceptor implements Interceptor {
    private static final int BODY_MAX_SIZE = 30720;
    private static final String FILE_NAME = "okhttp_illegalstate";
    private static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.bin";
    private Context mContext;

    public ExpTraceInterceptor(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        try {
            return chain.proceed(request);
        } catch (ArrayIndexOutOfBoundsException e) {
            e = e;
            if (!recoverFromLoadPublicSuffixFailed(e)) {
                throw new IOException(e);
            }
            saveExceptionToFile(dumpExceptionData(request, chain, e).toString());
            throw e;
        } catch (IllegalStateException e2) {
            e = e2;
            if (!recoverFromLoadPublicSuffixFailed(e)) {
            }
        } catch (NullPointerException e3) {
            String message = e3.getMessage();
            if (message != null && message.contains("ssl_session == null")) {
                e3.printStackTrace();
                throw new IOException(e3);
            }
            throw e3;
        }
    }

    private boolean recoverFromLoadPublicSuffixFailed(Exception exc) {
        Field declaredField;
        boolean z = false;
        if (exc == null || !exc.getMessage().contains("Unable to load publicsuffixes.gz")) {
            return false;
        }
        synchronized (PublicSuffixDatabase.get()) {
            try {
                try {
                    try {
                        declaredField = PublicSuffixDatabase.class.getDeclaredField("publicSuffixListBytes");
                        declaredField.setAccessible(true);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                }
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            }
            if (declaredField.get(PublicSuffixDatabase.get()) != null) {
                return true;
            }
            Pair<byte[], byte[]> sufffixs = getSufffixs();
            Method declaredMethod = PublicSuffixDatabase.class.getDeclaredMethod("setListBytes", byte[].class, byte[].class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(PublicSuffixDatabase.get(), sufffixs.first, sufffixs.second);
            z = true;
            return z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Pair<byte[], byte[]> getSufffixs() {
        BufferedSource bufferedSource;
        Throwable th;
        byte[] bArr;
        BufferedSource bufferedSource2;
        byte[] bArr2;
        IOException iOException;
        byte[] bArr3;
        byte[] bArr4 = null;
        try {
            InputStream open = this.mContext.getAssets().open(PUBLIC_SUFFIX_RESOURCE);
            if (open != null) {
                bufferedSource = Okio.buffer(new GzipSource(Okio.source(open)));
                try {
                    try {
                        bArr3 = new byte[bufferedSource.readInt()];
                        try {
                            bufferedSource.readFully(bArr3);
                            bArr4 = new byte[bufferedSource.readInt()];
                            try {
                                bufferedSource.readFully(bArr4);
                            } catch (IOException e) {
                                bufferedSource2 = bufferedSource;
                                bArr = bArr3;
                                bArr2 = bArr4;
                                iOException = e;
                                try {
                                    iOException.printStackTrace();
                                    Util.closeQuietly(bufferedSource2);
                                    bArr4 = bArr2;
                                    bArr3 = bArr;
                                    if (bArr3 == null) {
                                    }
                                    if (bArr4 == null) {
                                    }
                                    return new Pair<>(bArr3, bArr4);
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedSource = bufferedSource2;
                                    Util.closeQuietly(bufferedSource);
                                    throw th;
                                }
                            }
                        } catch (IOException e2) {
                            bufferedSource2 = bufferedSource;
                            bArr = bArr3;
                            bArr2 = null;
                            iOException = e2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        Util.closeQuietly(bufferedSource);
                        throw th;
                    }
                } catch (IOException e3) {
                    bufferedSource2 = bufferedSource;
                    bArr = null;
                    iOException = e3;
                    bArr2 = null;
                }
            } else {
                bArr3 = null;
                bufferedSource = null;
            }
            Util.closeQuietly(bufferedSource);
        } catch (IOException e4) {
            bArr = null;
            bufferedSource2 = null;
            bArr2 = null;
            iOException = e4;
        } catch (Throwable th4) {
            bufferedSource = null;
            th = th4;
        }
        if (bArr3 == null) {
            bArr3 = new byte[0];
        }
        if (bArr4 == null) {
            bArr4 = new byte[0];
        }
        return new Pair<>(bArr3, bArr4);
    }

    private JSONObject dumpExceptionData(Request request, Interceptor.Chain chain, Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_url", request.url().toString());
            if (request.headers() != null) {
                jSONObject.put("request_headers", request.headers().toString());
            }
            if (request.body() != null && request.body().contentLength() < 30720) {
                Buffer buffer = new Buffer();
                request.body().writeTo(buffer);
                jSONObject.put("request_body", buffer.readUtf8());
            }
            if (chain != null && chain.connection() != null) {
                jSONObject.put("connection_info", chain.connection().toString());
            }
            jSONObject.put("exception_stack", Log.getStackTraceString(exc));
        } catch (Exception e) {
            try {
                jSONObject.put("json_exp", Log.getStackTraceString(e));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [213=4] */
    private synchronized void saveExceptionToFile(String str) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str)) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream = new FileOutputStream(new File(this.mContext.getFilesDir(), FILE_NAME));
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.flush();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (IOException e4) {
                e = e4;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }
}

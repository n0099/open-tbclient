package com.baidu.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static String ys(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "process";
        }
        try {
            return new String(Base64.encode(str.getBytes("UTF-8"), 0), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [90=4] */
    public static String readAssetData(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        BufferedReader bufferedReader;
        String str2 = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                inputStream = context.getAssets().open(str);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                } catch (IOException e) {
                    bufferedReader = null;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
            } catch (IOException e2) {
                bufferedReader = null;
                inputStream = null;
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
                bufferedReader = null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                str2 = sb.toString();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (IOException e5) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                    }
                }
                return str2;
            } catch (Throwable th4) {
                th = th4;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e8) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e9) {
                    }
                }
                throw th;
            }
        }
        return str2;
    }

    public static JSONObject yt(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return new JSONObject();
        }
    }
}

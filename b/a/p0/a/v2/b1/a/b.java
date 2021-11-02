package b.a.p0.a.v2.b1.a;

import android.text.TextUtils;
import android.util.AtomicFile;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r5v9, resolved type: java.nio.channels.FileChannel */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(@NonNull JSONArray jSONArray, @NonNull File file, int i2) {
        InterceptResult invokeLLI;
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        FileLock fileLock;
        AtomicFile atomicFile;
        FileLock fileLock2;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, jSONArray, file, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            FileLock fileLock3 = null;
            fileLock3 = null;
            fileLock3 = null;
            AtomicFile atomicFile2 = null;
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    SparseArray sparseArray = new SparseArray(i2);
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < i2; i3++) {
                        arrayList.add(bufferedReader.readLine());
                    }
                    for (int i4 = 0; i4 < i2; i4++) {
                        String str = (String) arrayList.get(i4);
                        if (TextUtils.isEmpty(str) || (optJSONArray = new JSONObject(str).optJSONArray("descriptions")) == null) {
                            return false;
                        }
                        HashMap hashMap = new HashMap();
                        for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(i5);
                            hashMap.put(jSONObject.optString("name"), jSONObject);
                        }
                        sparseArray.put(i4, hashMap);
                    }
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i6);
                        String optString = jSONObject2.optString("name");
                        int i7 = 0;
                        while (true) {
                            if (i7 >= i2) {
                                break;
                            } else if (((Map) sparseArray.get(i7)).containsKey(optString)) {
                                ((Map) sparseArray.get(i7)).put(optString, jSONObject2);
                                break;
                            } else {
                                if (i7 == i2 - 1) {
                                    ((Map) sparseArray.get(i7)).put(optString, jSONObject2);
                                }
                                i7++;
                            }
                        }
                    }
                    for (int i8 = 0; i8 < i2; i8++) {
                        JSONObject jSONObject3 = new JSONObject((String) arrayList.get(i8));
                        JSONArray jSONArray2 = new JSONArray();
                        jSONObject3.optJSONArray("descriptions");
                        for (Map.Entry entry : ((Map) sparseArray.get(i8)).entrySet()) {
                            jSONArray2.put(entry.getValue());
                        }
                        jSONObject3.put("descriptions", jSONArray2);
                        if (i8 != i2 - 1) {
                            sb.append(jSONObject3.toString());
                            sb.append(StringUtils.LF);
                        } else {
                            sb.append(jSONObject3.toString());
                        }
                    }
                    bufferedReader.close();
                    atomicFile = new AtomicFile(file);
                    try {
                        atomicFile.startWrite();
                        fileOutputStream = atomicFile.startWrite();
                    } catch (IOException | JSONException unused) {
                        fileOutputStream = null;
                        fileLock2 = null;
                    }
                    try {
                        fileChannel = fileOutputStream.getChannel();
                    } catch (IOException | JSONException unused2) {
                        fileLock2 = null;
                        atomicFile2 = atomicFile;
                        fileLock = fileLock2;
                        fileChannel = fileLock2;
                        if (atomicFile2 != null) {
                            try {
                                atomicFile2.failWrite(fileOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                fileLock3 = fileLock;
                                if (fileLock3 != null && fileChannel != null) {
                                    try {
                                        fileLock3.release();
                                        fileChannel.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                throw th;
                            }
                        }
                        if (fileLock != null && fileChannel != null) {
                            try {
                                fileLock.release();
                                fileChannel.close();
                            } catch (IOException unused4) {
                            }
                        }
                        return false;
                    }
                } catch (IOException | JSONException unused5) {
                    fileOutputStream = null;
                    fileLock = null;
                    fileChannel = null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
            try {
                fileLock3 = fileChannel.lock();
                fileOutputStream.write(sb.toString().getBytes());
                atomicFile.finishWrite(fileOutputStream);
                if (fileLock3 == null || fileChannel == null) {
                    return true;
                }
                try {
                    fileLock3.release();
                    fileChannel.close();
                    return true;
                } catch (IOException unused6) {
                    return true;
                }
            } catch (IOException | JSONException unused7) {
                FileLock fileLock4 = fileLock3;
                atomicFile2 = atomicFile;
                fileLock = fileLock4;
                fileChannel = fileChannel;
                if (atomicFile2 != null) {
                }
                if (fileLock != null) {
                    fileLock.release();
                    fileChannel.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (fileLock3 != null) {
                    fileLock3.release();
                    fileChannel.close();
                }
                throw th;
            }
        }
        return invokeLLI.booleanValue;
    }
}

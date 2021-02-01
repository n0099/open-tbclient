package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f4246a = null;

    public static void a(String str) {
        f4246a = str;
    }

    public static String a() {
        return f4246a;
    }

    public static String b() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "AR/ARResource" + File.separator + a();
    }

    public static String a(String str, int i) {
        String b2 = b();
        String str2 = null;
        if (b2 != null) {
            switch (i) {
                case 0:
                    str2 = b2 + "/track";
                    break;
                case 1:
                default:
                    str2 = b2 + "/normal";
                    break;
                case 2:
                    str2 = b2 + "/track";
                    break;
                case 3:
                    str2 = b2 + "/udt";
                    break;
                case 4:
                    str2 = b2 + "/npc";
                    break;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return str2 + File.separator + str;
        }
        return str2;
    }

    public static boolean a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [197=5, 198=5, 200=5, 201=5, 203=5, 204=5, 206=5] */
    public static void a(String str, String str2) {
        Throwable th;
        BufferedWriter bufferedWriter;
        OutputStreamWriter outputStreamWriter;
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter2;
        File file = new File(b());
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = b() + File.separator + str2;
        File file2 = new File(str3);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
            }
        }
        if (b(str, str2)) {
            return;
        }
        try {
            fileOutputStream = new FileOutputStream(str3, true);
            try {
                outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                try {
                    bufferedWriter2 = new BufferedWriter(outputStreamWriter);
                } catch (FileNotFoundException e2) {
                    bufferedWriter2 = null;
                } catch (UnsupportedEncodingException e3) {
                    bufferedWriter2 = null;
                } catch (IOException e4) {
                    bufferedWriter2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = null;
                }
            } catch (FileNotFoundException e5) {
                bufferedWriter2 = null;
                outputStreamWriter = null;
            } catch (UnsupportedEncodingException e6) {
                bufferedWriter2 = null;
                outputStreamWriter = null;
            } catch (IOException e7) {
                bufferedWriter2 = null;
                outputStreamWriter = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = null;
                outputStreamWriter = null;
            }
        } catch (FileNotFoundException e8) {
            bufferedWriter2 = null;
            outputStreamWriter = null;
            fileOutputStream = null;
        } catch (UnsupportedEncodingException e9) {
            bufferedWriter2 = null;
            outputStreamWriter = null;
            fileOutputStream = null;
        } catch (IOException e10) {
            bufferedWriter2 = null;
            outputStreamWriter = null;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = null;
            outputStreamWriter = null;
            fileOutputStream = null;
        }
        try {
            bufferedWriter2.write(str);
            bufferedWriter2.newLine();
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e11) {
                    return;
                }
            }
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e12) {
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e13) {
                    return;
                }
            }
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (UnsupportedEncodingException e14) {
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e15) {
                    return;
                }
            }
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (IOException e16) {
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e17) {
                    return;
                }
            }
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedWriter = bufferedWriter2;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e18) {
                    throw th;
                }
            }
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static boolean b(String str, String str2) {
        HashSet<String> b2 = b(b() + File.separator + str2);
        if (b2 != null) {
            Iterator<String> it = b2.iterator();
            while (it.hasNext()) {
                String next = it.next();
                boolean equals = str.equals(next);
                a.a("item = " + next + ", key = " + str + ", result = " + equals);
                if (equals) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [273=4, 274=4, 276=4, 277=4, 279=4, 280=4, 282=4] */
    private static HashSet<String> b(String str) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader2;
        HashSet<String> hashSet = new HashSet<>();
        if (!new File(str).exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            hashSet.add(readLine);
                        } catch (FileNotFoundException e) {
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e2) {
                                    return null;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return null;
                            }
                            return null;
                        } catch (IOException e3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e4) {
                                    return null;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return null;
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    throw th;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    a.a("keysSet size is " + hashSet.size());
                    return hashSet;
                } catch (FileNotFoundException e7) {
                    bufferedReader2 = null;
                } catch (IOException e8) {
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (FileNotFoundException e9) {
                bufferedReader2 = null;
                inputStreamReader = null;
            } catch (IOException e10) {
                bufferedReader = null;
                inputStreamReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                inputStreamReader = null;
            }
        } catch (FileNotFoundException e11) {
            bufferedReader2 = null;
            inputStreamReader = null;
            fileInputStream = null;
        } catch (IOException e12) {
            bufferedReader = null;
            inputStreamReader = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            inputStreamReader = null;
            fileInputStream = null;
        }
    }
}

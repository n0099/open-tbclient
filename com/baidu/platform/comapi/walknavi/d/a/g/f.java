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
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f2991a = null;

    public static void a(String str) {
        f2991a = str;
    }

    public static String a() {
        return f2991a;
    }

    public static String b() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "AR/ARResource" + File.separator + a();
    }

    public static String a(String str, int i) {
        String b = b();
        String str2 = null;
        if (b != null) {
            switch (i) {
                case 0:
                    str2 = b + "/track";
                    break;
                case 1:
                default:
                    str2 = b + "/normal";
                    break;
                case 2:
                    str2 = b + "/track";
                    break;
                case 3:
                    str2 = b + "/udt";
                    break;
                case 4:
                    str2 = b + "/npc";
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
        OutputStreamWriter outputStreamWriter;
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        FileOutputStream fileOutputStream2;
        BufferedWriter bufferedWriter2 = null;
        r1 = null;
        r1 = null;
        bufferedWriter2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        bufferedWriter2 = null;
        OutputStreamWriter outputStreamWriter2 = null;
        BufferedWriter bufferedWriter3 = null;
        BufferedWriter bufferedWriter4 = null;
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
                    bufferedWriter = new BufferedWriter(outputStreamWriter);
                    try {
                        bufferedWriter.write(str);
                        bufferedWriter.newLine();
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e2) {
                                return;
                            }
                        }
                        if (outputStreamWriter != null) {
                            outputStreamWriter.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (FileNotFoundException e3) {
                        outputStreamWriter2 = outputStreamWriter;
                        fileOutputStream2 = fileOutputStream;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e4) {
                                return;
                            }
                        }
                        if (outputStreamWriter2 != null) {
                            outputStreamWriter2.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                    } catch (UnsupportedEncodingException e5) {
                        bufferedWriter3 = bufferedWriter;
                        if (bufferedWriter3 != null) {
                            try {
                                bufferedWriter3.close();
                            } catch (IOException e6) {
                                return;
                            }
                        }
                        if (outputStreamWriter != null) {
                            outputStreamWriter.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (IOException e7) {
                        bufferedWriter4 = bufferedWriter;
                        if (bufferedWriter4 != null) {
                            try {
                                bufferedWriter4.close();
                            } catch (IOException e8) {
                                return;
                            }
                        }
                        if (outputStreamWriter != null) {
                            outputStreamWriter.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        bufferedWriter2 = bufferedWriter;
                        th = th;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e9) {
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
                } catch (FileNotFoundException e10) {
                    bufferedWriter = null;
                    outputStreamWriter2 = outputStreamWriter;
                    fileOutputStream2 = fileOutputStream;
                } catch (UnsupportedEncodingException e11) {
                } catch (IOException e12) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e13) {
                bufferedWriter = null;
                fileOutputStream2 = fileOutputStream;
            } catch (UnsupportedEncodingException e14) {
                outputStreamWriter = null;
            } catch (IOException e15) {
                outputStreamWriter = null;
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter = null;
            }
        } catch (FileNotFoundException e16) {
            bufferedWriter = null;
            fileOutputStream2 = null;
        } catch (UnsupportedEncodingException e17) {
            outputStreamWriter = null;
            fileOutputStream = null;
        } catch (IOException e18) {
            outputStreamWriter = null;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            outputStreamWriter = null;
            fileOutputStream = null;
        }
    }

    public static boolean b(String str, String str2) {
        HashSet<String> b = b(b() + File.separator + str2);
        if (b != null) {
            Iterator<String> it = b.iterator();
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
        Throwable th;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2;
        FileInputStream fileInputStream2;
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
                            inputStreamReader2 = inputStreamReader;
                            fileInputStream2 = fileInputStream;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e2) {
                                    return null;
                                }
                            }
                            if (inputStreamReader2 != null) {
                                inputStreamReader2.close();
                            }
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
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
                        } catch (Throwable th2) {
                            th = th2;
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
                    inputStreamReader2 = inputStreamReader;
                    fileInputStream2 = fileInputStream;
                } catch (IOException e8) {
                    bufferedReader = null;
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } catch (FileNotFoundException e9) {
                bufferedReader2 = null;
                inputStreamReader2 = null;
                fileInputStream2 = fileInputStream;
            } catch (IOException e10) {
                bufferedReader = null;
                inputStreamReader = null;
            } catch (Throwable th4) {
                bufferedReader = null;
                inputStreamReader = null;
                th = th4;
            }
        } catch (FileNotFoundException e11) {
            bufferedReader2 = null;
            inputStreamReader2 = null;
            fileInputStream2 = null;
        } catch (IOException e12) {
            bufferedReader = null;
            inputStreamReader = null;
            fileInputStream = null;
        } catch (Throwable th5) {
            bufferedReader = null;
            inputStreamReader = null;
            fileInputStream = null;
            th = th5;
        }
    }
}

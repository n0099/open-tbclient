package com.baidu.swan.apps.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean vx() {
        return com.baidu.swan.apps.u.a.CK().vx();
    }

    public static void c(File file, File file2) throws IOException {
        FileChannel fileChannel;
        FileChannel channel;
        FileChannel channel2;
        FileChannel fileChannel2 = null;
        try {
            channel = new FileInputStream(file).getChannel();
            try {
                channel2 = new FileOutputStream(file2).getChannel();
            } catch (Throwable th) {
                th = th;
                fileChannel2 = channel;
                fileChannel = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
        try {
            channel2.transferFrom(channel, 0L, channel.size());
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
        } catch (Throwable th3) {
            fileChannel2 = channel;
            fileChannel = channel2;
            th = th3;
            if (fileChannel2 != null) {
                fileChannel2.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
    }

    public static void dB(String str) {
        b(str, null, null, true);
    }

    public static void k(String str, String str2, String str3) {
        b(str, str2, str3, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [137=5, 139=4, 140=4, 141=4, 142=4, 146=4, 148=4, 149=4, 150=4, 151=4, 156=4, 158=4, 159=4, 160=4, 161=4] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0145 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(String str, String str2, String str3, boolean z) {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader2;
        FileInputStream fileInputStream2;
        BufferedWriter bufferedWriter = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader3 = null;
        BufferedWriter bufferedWriter2 = null;
        try {
            File file = new File(str);
            String absolutePath = file.getParentFile().getAbsolutePath();
            String name = file.getName();
            File file2 = new File(absolutePath + File.separator + name + ".tmp");
            File file3 = new File(absolutePath + File.separator + name + ".bak");
            if (z) {
                if (file3.exists()) {
                    file3.renameTo(file);
                }
                if (0 != 0) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        if (DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (0 != 0) {
                    try {
                        bufferedWriter2.close();
                        return;
                    } catch (IOException e3) {
                        if (DEBUG) {
                            e3.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    if (file3.exists()) {
                        c(file3, file);
                    } else {
                        c(file, file3);
                    }
                    BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter(file2));
                    boolean z2 = false;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.contains(str2)) {
                                bufferedWriter3.write(str3 + "\n");
                                z2 = true;
                            }
                            bufferedWriter3.write(readLine + "\n");
                        } catch (Exception e4) {
                            e = e4;
                            bufferedWriter = bufferedWriter3;
                            bufferedReader2 = bufferedReader;
                            fileInputStream2 = fileInputStream;
                            try {
                                e.printStackTrace();
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e5) {
                                        if (DEBUG) {
                                            e5.printStackTrace();
                                        }
                                    }
                                }
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e6) {
                                        if (DEBUG) {
                                            e6.printStackTrace();
                                        }
                                    }
                                }
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                        return;
                                    } catch (IOException e7) {
                                        if (DEBUG) {
                                            e7.printStackTrace();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e8) {
                                        if (DEBUG) {
                                            e8.printStackTrace();
                                        }
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e9) {
                                        if (DEBUG) {
                                            e9.printStackTrace();
                                        }
                                    }
                                }
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e10) {
                                        if (DEBUG) {
                                            e10.printStackTrace();
                                        }
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter3;
                            if (bufferedReader != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            if (bufferedWriter != null) {
                            }
                            throw th;
                        }
                    }
                    bufferedWriter3.flush();
                    if (z2) {
                        file2.renameTo(file);
                    } else {
                        file2.delete();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e11) {
                            if (DEBUG) {
                                e11.printStackTrace();
                            }
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e12) {
                            if (DEBUG) {
                                e12.printStackTrace();
                            }
                        }
                    }
                    if (bufferedWriter3 != null) {
                        try {
                            bufferedWriter3.close();
                        } catch (IOException e13) {
                            if (DEBUG) {
                                e13.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e14) {
                    e = e14;
                    bufferedReader2 = bufferedReader;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e15) {
                e = e15;
                bufferedReader2 = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Exception e16) {
            e = e16;
            bufferedReader2 = null;
            fileInputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            fileInputStream = null;
        }
    }
}

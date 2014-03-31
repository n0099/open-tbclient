package com.baidu.tbadk.core.util;

import android.content.Context;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteFullException;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class TiebaStatic {
    static {
        com.baidu.adp.lib.util.f.a("com.baidu.tieba.im");
    }

    public static void a(Context context) {
        try {
            com.baidu.adp.lib.stats.g.a().a(context, String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/newlog", String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/logsync", "tieba", "tieba_android", com.baidu.tbadk.core.data.n.c(), com.baidu.tbadk.core.data.n.j(), TbadkApplication.B(), TbadkApplication.j().z(), TbadkApplication.j().C(), w.a + "/" + com.baidu.tbadk.core.data.n.f() + "/stat");
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "init", e.toString());
        }
    }

    public static void a(String str, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.g.a().a(str2, str, str3);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "setUserInfo", e.toString());
        }
    }

    public static void a(com.baidu.tbadk.core.util.a.a aVar) {
        if (aVar != null && aVar.c().a.f <= 180000) {
            try {
                if (aVar.c().a.f >= 0 && aVar.c().a.c >= 0 && aVar.c().a.d >= 0) {
                    int i = aVar.b().b;
                    if (!aVar.b().a()) {
                        i = aVar.b().a;
                    }
                    String str = null;
                    String a = be.a();
                    if (i != 0) {
                        str = aVar.b().c;
                        com.baidu.adp.lib.util.f.d("api=" + aVar.a().b() + " downsize=" + aVar.c().a.b + " upsize=" + aVar.c().a.a + " dns=" + aVar.c().a.g + " from=" + a + " cost=" + aVar.c().a.f + " conTime=" + aVar.c().a.c + " rspTime=" + aVar.c().a.d + " retry=" + aVar.c().a.e + " errorCode=" + aVar.b().b);
                    }
                    if (aVar.a().g) {
                        com.baidu.adp.lib.stats.g.a().a(i == 0 ? null : aVar.a().b(), aVar.a().f, a, aVar.c().a.b, aVar.c().a.a, aVar.c().a.f, aVar.c().a.c, aVar.c().a.d, aVar.c().a.e, i, str, new Object[0]);
                    } else {
                        com.baidu.adp.lib.stats.g.a().b(aVar.a().b(), aVar.a().f, a, aVar.c().a.b, aVar.c().a.a, aVar.c().a.f, aVar.c().a.c, aVar.c().a.d, aVar.c().a.e, i, str, new Object[0]);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
            }
        }
    }

    public static void a(SocketResponsedMessage socketResponsedMessage) {
        a(socketResponsedMessage, (String) null);
    }

    public static void a(SocketResponsedMessage socketResponsedMessage, String str) {
        if (socketResponsedMessage != null) {
            String str2 = null;
            try {
                if (socketResponsedMessage.h() != null && (socketResponsedMessage.h() instanceof com.baidu.tbadk.message.websockt.d)) {
                    str2 = b(String.valueOf(((com.baidu.tbadk.message.websockt.d) socketResponsedMessage.h()).k()));
                }
                if (str == null) {
                    com.baidu.adp.lib.stats.g.a().a("im", String.valueOf(socketResponsedMessage.g()), str2, null, socketResponsedMessage.a(), 0L, socketResponsedMessage.c(), 0L, 0L, socketResponsedMessage.b(), socketResponsedMessage.e(), socketResponsedMessage.f(), new Object[0]);
                } else {
                    com.baidu.adp.lib.stats.g.a().a("im", String.valueOf(socketResponsedMessage.g()), str2, null, socketResponsedMessage.a(), 0L, socketResponsedMessage.c(), 0L, 0L, socketResponsedMessage.b(), socketResponsedMessage.e(), socketResponsedMessage.f(), "msgtype", str);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
            }
        }
    }

    public static void a(long j, int i, String str, String str2) {
        com.baidu.adp.lib.stats.g.a().a("msg", "message_id", Long.valueOf(j), "op_type", Integer.valueOf(i), "stat", str2, "link", str);
    }

    public static void a(String str) {
        try {
            com.baidu.adp.lib.stats.g.a().a(str, (String) null, (String) null, new Object[0]);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "crash", e.toString());
        }
    }

    public static void a(Throwable th, String str, Object... objArr) {
        if (th != null) {
            if (th instanceof SQLiteDatabaseCorruptException) {
                a(str, -14, th.toString(), objArr);
            } else if (th instanceof SQLiteAbortException) {
                a(str, -11, th.toString(), objArr);
            } else if (th instanceof SQLiteConstraintException) {
                a(str, -12, th.toString(), objArr);
            } else if (th instanceof SQLiteDiskIOException) {
                a(str, -15, th.toString(), objArr);
            } else if (th instanceof SQLiteFullException) {
                a(str, -16, th.toString(), objArr);
            } else if (th instanceof SQLiteDoneException) {
                a(str, -19, th.toString(), objArr);
            } else {
                a(str, -17, th.toString(), objArr);
            }
        }
    }

    public static void a(String str, int i, String str2, Object... objArr) {
        try {
            com.baidu.adp.lib.stats.g.a().b(str, null, be.a(), i, str2, objArr);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "printDBExceptionLog", e.toString());
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            if (TbadkApplication.j().x()) {
                StatService.onEvent(context, str, str2, 1);
            }
            com.baidu.adp.lib.stats.g.a().a(str, str2, 1, new Object[0]);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "eventStat", e.toString());
        }
    }

    public static void a(Context context, String str, String str2, int i, Object... objArr) {
        try {
            if (TbadkApplication.j().x()) {
                StatService.onEvent(context, str, str2, 1);
            }
            com.baidu.adp.lib.stats.g.a().a(str, str2, 1, objArr);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "eventStat", e.toString());
        }
    }

    public static void a(String str, int i, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.g.a().c("op_img", str, be.a(), i, str2, "img_inf", str3);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "imgError", e.toString());
        }
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String a = com.baidu.adp.lib.stats.o.a((String.valueOf(TbadkApplication.y()) + str).getBytes());
                return a.substring(a.length() - 16, a.length());
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(e.getMessage());
            }
        }
        return null;
    }

    public static void b(String str, int i, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.g.a().d("op_voice", str, be.a(), i, str2, "voice_inf", str3);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "voiceError", e.toString());
        }
    }

    public static synchronized void a(int i, int i2, String str, String str2, String str3, int i3, String str4, long j, int i4, String str5) {
        synchronized (TiebaStatic.class) {
            try {
                String a = com.baidu.tbadk.core.log.i.a(i);
                com.baidu.adp.lib.stats.g a2 = com.baidu.adp.lib.stats.g.a();
                Object[] objArr = new Object[22];
                objArr[0] = "cmd";
                objArr[1] = String.valueOf(i);
                objArr[2] = "cmdRemark";
                objArr[3] = a;
                objArr[4] = "seqID";
                objArr[5] = String.valueOf(i2);
                objArr[6] = "reason";
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                objArr[7] = str;
                objArr[8] = "action";
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                objArr[9] = str2;
                objArr[10] = "result";
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                objArr[11] = str3;
                objArr[12] = "errorCode";
                objArr[13] = String.valueOf(i3);
                objArr[14] = "errorMsg";
                if (TextUtils.isEmpty(str4)) {
                    str4 = "";
                }
                objArr[15] = str4;
                objArr[16] = "costTime";
                objArr[17] = String.valueOf(j);
                objArr[18] = "size";
                objArr[19] = String.valueOf(0);
                objArr[20] = "comment";
                if (TextUtils.isEmpty(str5)) {
                    str5 = "";
                }
                objArr[21] = str5;
                a2.b("im", objArr);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("TiebaStatic", "im", e.toString());
            }
        }
    }

    public static synchronized void b(String str, String str2, String str3) {
        synchronized (TiebaStatic.class) {
            a(0, 0, str, str2, str3, 0, null, 0L, 0, null);
        }
    }

    public static synchronized void a(int i, int i2, String str, String str2, String str3, int i3, String str4) {
        synchronized (TiebaStatic.class) {
            a(i, 0, str, str2, null, i3, str4, 0L, 0, null);
        }
    }

    public static synchronized void a(int i, int i2, String str, String str2, String str3, int i3, String str4, long j) {
        synchronized (TiebaStatic.class) {
            a(i, 0, str, str2, str3, i3, str4, j, 0, null);
        }
    }

    public static void a(String str, long j, long j2, long j3, long j4, long j5) {
        if (j > 0 && j3 > 0 && j2 >= 0 && j4 >= 0 && j5 >= 0) {
            try {
                com.baidu.adp.lib.stats.g.a().a(str, null, null, j3, 0, null, "all_cost", Long.valueOf(j), "pre_cost", Long.valueOf(j2), "con_cost", Long.valueOf(j4), "show_cost", Long.valueOf(j5));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("TiebaStatic", "page", e.toString());
            }
        }
    }

    public static void a(Exception exc, String str) {
        if (exc != null) {
            a(exc.getMessage(), str);
        } else {
            a("", str);
        }
    }

    public static void a(String str, String str2) {
        String a = be.a();
        try {
            if (w.a()) {
                com.baidu.adp.lib.stats.g.a().a(str2, null, a, -27, str, "sd_state", Environment.getExternalStorageState(), "sd_size", Long.valueOf(w.e()));
            } else {
                com.baidu.adp.lib.stats.g.a().a(str2, null, a, -23, str, "sd_state", Environment.getExternalStorageState());
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "file", e.toString());
        }
    }

    public static void a() {
        try {
            com.baidu.adp.lib.stats.g.a().d();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "save", e.toString());
        }
    }

    public static synchronized void a(com.baidu.adp.lib.network.http.e eVar) {
        synchronized (TiebaStatic.class) {
            if (eVar.c() != null && eVar.c().size() > 0) {
                String b = eVar.a().b("sid");
                a(b, eVar.a().b(), eVar.c().get(0));
                if (eVar.c().size() > 1) {
                    a(b, eVar.a().b(), eVar.c().get(eVar.c().size() - 1));
                }
            }
        }
    }

    private static synchronized void a(String str, String str2, com.baidu.adp.lib.network.http.d dVar) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.f <= 180000) {
                    try {
                        if (dVar.f >= 0 && dVar.c >= 0 && dVar.d >= 0) {
                            int i = dVar.i;
                            String str3 = null;
                            String a = be.a();
                            if (i != 0) {
                                str3 = dVar.h;
                                com.baidu.adp.lib.util.f.d("api=" + c(str2) + " downsize=" + dVar.b + " upsize=" + dVar.a + " dns=" + dVar.g + " from=" + a + " cost=" + dVar.f + " conTime=" + dVar.c + " rspTime=" + dVar.d + " retry=" + dVar.e + " errorCode=" + dVar.i);
                            }
                            com.baidu.adp.lib.stats.g.a().a(null, str, a, dVar.b, dVar.a, dVar.f, dVar.c, dVar.d, dVar.e, i, str3, new Object[0]);
                        }
                    } catch (Exception e) {
                        com.baidu.adp.lib.util.f.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
                    }
                }
            }
        }
    }

    public static synchronized void b(com.baidu.adp.lib.network.http.e eVar) {
        synchronized (TiebaStatic.class) {
            if (eVar.c() != null && eVar.c().size() > 0) {
                String b = eVar.a().b("sid");
                b(b, eVar.a().b(), eVar.c().get(0));
                if (eVar.c().size() > 1) {
                    b(b, eVar.a().b(), eVar.c().get(eVar.c().size() - 1));
                }
            }
        }
    }

    private static synchronized void b(String str, String str2, com.baidu.adp.lib.network.http.d dVar) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.f <= 180000) {
                    try {
                        if (dVar.f >= 0 && dVar.c >= 0 && dVar.d >= 0) {
                            int i = dVar.i;
                            String str3 = null;
                            String a = be.a();
                            if (i != 0) {
                                str3 = dVar.h;
                                com.baidu.adp.lib.util.f.d("api=" + c(str2) + " downsize=" + dVar.b + " upsize=" + dVar.a + " dns=" + dVar.g + " from=" + a + " cost=" + dVar.f + " conTime=" + dVar.c + " rspTime=" + dVar.d + " retry=" + dVar.e + " errorCode=" + dVar.i);
                            }
                            com.baidu.adp.lib.stats.g.a().b(c(str2), str, a, dVar.b, dVar.a, dVar.f, dVar.c, dVar.d, dVar.e, i, str3, new Object[0]);
                        }
                    } catch (Exception e) {
                        com.baidu.adp.lib.util.f.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
                    }
                }
            }
        }
    }

    private static String c(String str) {
        if (str == null) {
            return null;
        }
        String str2 = com.baidu.tbadk.core.data.n.a;
        if (str.startsWith(str2)) {
            int indexOf = str.indexOf(63);
            if (indexOf < 0) {
                indexOf = str.length();
            }
            return str.substring(str2.length(), indexOf);
        }
        return str;
    }
}

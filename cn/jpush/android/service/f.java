package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.jpush.android.api.JPushMessage;
import com.coloros.mcssdk.mode.CommandMessage;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public final class f {
    private static volatile f a;
    private static final Object d = new Object();
    private TagAliasReceiver b;
    private ConcurrentHashMap<Long, cn.jpush.android.api.a> c = new ConcurrentHashMap<>();
    private AtomicBoolean e = new AtomicBoolean(false);

    private f() {
    }

    private cn.jpush.android.api.a a(long j) {
        return this.c.get(Long.valueOf(j));
    }

    public static f a() {
        if (a == null) {
            synchronized (d) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    private static String a(cn.jpush.android.api.a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            if (aVar.b != null && aVar.b.size() > 0) {
                return (String) aVar.b.toArray()[0];
            }
        } catch (Throwable th) {
        }
        return null;
    }

    private void a(Context context, int i, long j) {
        cn.jpush.android.api.a a2 = a(j);
        if (a2 == null) {
            return;
        }
        a(a2, i);
        b(j);
    }

    private static void a(cn.jpush.android.api.a aVar, int i) {
        if (aVar.e != 0 || aVar.c == null) {
            return;
        }
        aVar.c.gotResult(i, aVar.a, aVar.b);
    }

    private void b(long j) {
        this.c.remove(Long.valueOf(j));
    }

    private void b(Context context) {
        if (this.c == null || this.c.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, cn.jpush.android.api.a> entry : this.c.entrySet()) {
            if (entry.getValue().a(20000L)) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a(context, cn.jpush.android.api.b.c, ((Long) it.next()).longValue());
        }
    }

    private synchronized void c(Context context) {
        b(context);
        if (this.e.get() && this.c != null && this.c.isEmpty()) {
            try {
                if (this.b != null) {
                    context.unregisterReceiver(this.b);
                    this.b = null;
                }
            } catch (IllegalArgumentException e) {
                cn.jpush.android.d.f.c("TagAliasOperator", "Receiver not registered, cannot call unregisterReceiver", e);
            } catch (Exception e2) {
                cn.jpush.android.d.f.c("TagAliasOperator", "other exception", e2);
            }
            this.e.set(false);
        }
    }

    public final JPushMessage a(Intent intent) {
        boolean z = false;
        long longExtra = intent.getLongExtra("tagalias_seqid", -1L);
        int intExtra = intent.getIntExtra("tagalias_errorcode", 0);
        cn.jpush.android.api.a a2 = a(longExtra);
        if (a2 == null) {
            return null;
        }
        a().b(longExtra);
        if (intExtra == 0) {
            try {
                if (a2.f == 5) {
                    if (a2.e == 1) {
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(CommandMessage.TYPE_TAGS);
                        if (stringArrayListExtra != null) {
                            a2.b = new HashSet(stringArrayListExtra);
                        }
                    } else if (a2.e == 2) {
                        a2.a = intent.getStringExtra(CommandMessage.TYPE_ALIAS);
                    }
                } else if (a2.f == 6) {
                    z = intent.getBooleanExtra("validated", false);
                }
            } catch (Throwable th) {
            }
        }
        JPushMessage jPushMessage = new JPushMessage();
        jPushMessage.setErrorCode(intExtra);
        jPushMessage.setSequence(a2.d);
        if (a2.e != 1) {
            jPushMessage.setAlias(a2.a);
        } else if (a2.f == 6) {
            jPushMessage.setCheckTag(a(a2));
            jPushMessage.setTagCheckStateResult(z);
            jPushMessage.setTagCheckOperator(true);
        } else {
            jPushMessage.setTags(a2.b);
        }
        return jPushMessage;
    }

    public final synchronized void a(Context context) {
        if (!this.e.get()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addCategory(cn.jpush.android.a.c);
                intentFilter.addAction("cn.jpush.android.intent.TAG_ALIAS_TIMEOUT");
                intentFilter.addAction("cn.jpush.android.intent.TAG_ALIAS_CALLBACK");
                if (this.b == null) {
                    this.b = new TagAliasReceiver();
                }
                context.registerReceiver(this.b, intentFilter);
                this.e.set(true);
            } catch (Exception e) {
            }
        }
    }

    public final void a(Context context, int i, long j, cn.jpush.android.api.a aVar) {
        if (aVar != null) {
            if (aVar.e == 0) {
                if (aVar.c != null) {
                    aVar.c.gotResult(i, aVar.a, aVar.b);
                    b(j);
                    return;
                }
                return;
            }
            try {
                Intent intent = new Intent();
                intent.addCategory(cn.jpush.android.a.c);
                intent.setAction("cn.jpush.android.intent.RECEIVE_MESSAGE");
                intent.setPackage(context.getPackageName());
                if (aVar.e == 1) {
                    intent.putExtra(PushMessageHelper.MESSAGE_TYPE, 1);
                } else {
                    intent.putExtra(PushMessageHelper.MESSAGE_TYPE, 2);
                }
                intent.putExtra("tagalias_errorcode", i);
                intent.putExtra("tagalias_seqid", j);
                context.sendBroadcast(intent);
            } catch (Throwable th) {
                cn.jpush.android.d.f.c("TagAliasOperator", "onTagaliasTimeout error:" + th.getMessage());
            }
        }
    }

    public final void a(Context context, long j, int i, Intent intent) {
        if ("cn.jpush.android.intent.TAG_ALIAS_TIMEOUT".equals(intent.getAction())) {
            a(context, i, j);
        } else {
            cn.jpush.android.api.a a2 = a(j);
            if (a2 != null) {
                a().b(j);
                if (intent != null) {
                    try {
                        if (a2.f == 5) {
                            if (a2.e == 1) {
                                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(CommandMessage.TYPE_TAGS);
                                if (stringArrayListExtra != null) {
                                    a2.b = new HashSet(stringArrayListExtra);
                                }
                            } else if (a2.e == 2) {
                                a2.a = intent.getStringExtra(CommandMessage.TYPE_ALIAS);
                            }
                        } else if (a2.f == 6) {
                            intent.getBooleanExtra("validated", false);
                        }
                    } catch (Throwable th) {
                    }
                }
                a(a2, i);
            }
        }
        c(context);
    }

    public final void a(Context context, Long l, cn.jpush.android.api.a aVar) {
        b(context);
        this.c.put(l, aVar);
    }
}

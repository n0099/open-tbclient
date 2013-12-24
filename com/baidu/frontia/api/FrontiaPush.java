package com.baidu.frontia.api;

import android.content.Context;
import com.baidu.android.pushservice.internal.PushManager;
import com.baidu.android.pushservice.internal.PushSettings;
import com.baidu.frontia.FrontiaQuery;
import com.baidu.frontia.api.FrontiaPushListener;
import com.baidu.frontia.api.FrontiaPushUtil;
import com.baidu.frontia.base.stat.StatUtils;
import com.baidu.frontia.framework.IModule;
import com.baidu.frontia.module.push.FrontiaPushImpl;
import com.baidu.frontia.module.push.FrontiaPushListenerImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FrontiaPush implements IModule {
    private static FrontiaPush a = null;
    private FrontiaPushImpl b;
    private Context c;

    /* loaded from: classes.dex */
    class a {
        FrontiaPushListenerImpl.CommonMessageListenerImpl a = new FrontiaPushListenerImpl.CommonMessageListenerImpl() { // from class: com.baidu.frontia.api.FrontiaPush.a.1
            public void onFailure(int i, String str) {
                if (a.this.c != null) {
                    a.this.c.onFailure(i, str);
                }
            }

            public void onSuccess() {
                if (a.this.c != null) {
                    a.this.c.onSuccess();
                }
            }
        };
        private FrontiaPushListener.CommonMessageListener c;

        a(FrontiaPushListener.CommonMessageListener commonMessageListener) {
            this.c = commonMessageListener;
        }

        FrontiaPushListenerImpl.CommonMessageListenerImpl a() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    class b {
        FrontiaPushListenerImpl.DescribeMessageListenerImpl a = new FrontiaPushListenerImpl.DescribeMessageListenerImpl() { // from class: com.baidu.frontia.api.FrontiaPush.b.1
            public void onFailure(int i, String str) {
                if (b.this.c != null) {
                    b.this.c.onFailure(i, str);
                }
            }

            public void onSuccess(FrontiaPushListenerImpl.DescribeMessageResult describeMessageResult) {
                if (b.this.c != null) {
                    b.this.c.onSuccess(new FrontiaPushListener.DescribeMessageResult(describeMessageResult));
                }
            }
        };
        private FrontiaPushListener.DescribeMessageListener c;

        b(FrontiaPushListener.DescribeMessageListener describeMessageListener) {
            this.c = describeMessageListener;
        }

        FrontiaPushListenerImpl.DescribeMessageListenerImpl a() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    class c {
        FrontiaPushListenerImpl.ListMessageListenerImpl a = new FrontiaPushListenerImpl.ListMessageListenerImpl() { // from class: com.baidu.frontia.api.FrontiaPush.c.1
            public void onFailure(int i, String str) {
                if (c.this.c != null) {
                    c.this.c.onFailure(i, str);
                }
            }

            public void onSuccess(List<FrontiaPushListenerImpl.DescribeMessageResult> list) {
                if (c.this.c == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        c.this.c.onSuccess(arrayList);
                        return;
                    } else {
                        arrayList.add(new FrontiaPushListener.DescribeMessageResult(list.get(i2)));
                        i = i2 + 1;
                    }
                }
            }
        };
        private FrontiaPushListener.ListMessageListener c;

        c(FrontiaPushListener.ListMessageListener listMessageListener) {
            this.c = listMessageListener;
        }

        FrontiaPushListenerImpl.ListMessageListenerImpl a() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    class d {
        FrontiaPushListenerImpl.PushMessageListenerImpl a = new FrontiaPushListenerImpl.PushMessageListenerImpl() { // from class: com.baidu.frontia.api.FrontiaPush.d.1
            public void onFailure(int i, String str) {
                if (d.this.c != null) {
                    d.this.c.onFailure(i, str);
                }
            }

            public void onSuccess(String str) {
                if (d.this.c != null) {
                    d.this.c.onSuccess(str);
                }
            }
        };
        private FrontiaPushListener.PushMessageListener c;

        d(FrontiaPushListener.PushMessageListener pushMessageListener) {
            this.c = pushMessageListener;
        }

        FrontiaPushListenerImpl.PushMessageListenerImpl a() {
            return this.a;
        }
    }

    private FrontiaPush(Context context) {
        this.c = context;
        this.b = new FrontiaPushImpl(context);
    }

    public static FrontiaPush newInstance(Context context) {
        if (context == null) {
            return null;
        }
        if (a == null) {
            synchronized (FrontiaPush.class) {
                if (a == null) {
                    a = new FrontiaPush(context);
                }
            }
        }
        return a;
    }

    FrontiaPushImpl a() {
        return this.b;
    }

    public void deleteTags(List<String> list) {
        this.b.deleteTags(list);
    }

    public void describeMessage(String str, FrontiaPushListener.DescribeMessageListener describeMessageListener) {
        this.b.describeMessage(str, new b(describeMessageListener).a());
    }

    public void disableLbs() {
        this.b.disableLbs();
    }

    public void enableLbs() {
        this.b.enableLbs();
    }

    @Override // com.baidu.frontia.framework.IModule
    public void init(String str) {
        this.b.init(str);
    }

    public boolean isPushWorking() {
        return PushManager.isPushEnabled(this.c);
    }

    public void listMessage(FrontiaQuery frontiaQuery, FrontiaPushListener.ListMessageListener listMessageListener) {
        this.b.listMessage(frontiaQuery.toJSONObject(), new c(listMessageListener).a());
    }

    public void listTags() {
        this.b.listTags();
    }

    public void pushMessage(FrontiaPushUtil.MessageContent messageContent, FrontiaPushListener.PushMessageListener pushMessageListener) {
        this.b.pushMessage(messageContent.a(), new d(pushMessageListener).a());
    }

    public void pushMessage(FrontiaPushUtil.Trigger trigger, FrontiaPushUtil.MessageContent messageContent, FrontiaPushListener.PushMessageListener pushMessageListener) {
        this.b.pushMessage(trigger.a(), messageContent.a(), new d(pushMessageListener).a());
    }

    public void pushMessage(String str, FrontiaPushUtil.MessageContent messageContent, FrontiaPushListener.PushMessageListener pushMessageListener) {
        this.b.pushMessage(str, messageContent.a(), new d(pushMessageListener).a());
    }

    public void pushMessage(String str, FrontiaPushUtil.Trigger trigger, FrontiaPushUtil.MessageContent messageContent, FrontiaPushListener.PushMessageListener pushMessageListener) {
        this.b.pushMessage(str, trigger.a(), messageContent.a(), new d(pushMessageListener).a());
    }

    public void pushMessage(String str, String str2, FrontiaPushUtil.MessageContent messageContent, FrontiaPushListener.PushMessageListener pushMessageListener) {
        this.b.pushMessage(str, str2, messageContent.a(), new d(pushMessageListener).a());
    }

    public void pushMessage(String str, String str2, FrontiaPushUtil.Trigger trigger, FrontiaPushUtil.MessageContent messageContent, FrontiaPushListener.PushMessageListener pushMessageListener) {
        this.b.pushMessage(str, str2, trigger.a(), messageContent.a(), new d(pushMessageListener).a());
    }

    public void removeMessage(String str, FrontiaPushListener.CommonMessageListener commonMessageListener) {
        this.b.removeMessage(str, new a(commonMessageListener).a());
    }

    public void replaceMessage(String str, FrontiaPushUtil.Trigger trigger, FrontiaPushUtil.MessageContent messageContent, FrontiaPushListener.CommonMessageListener commonMessageListener) {
        this.b.replaceMessage(str, trigger.a(), messageContent.a(), new a(commonMessageListener).a());
    }

    public void replaceMessage(String str, String str2, FrontiaPushUtil.Trigger trigger, FrontiaPushUtil.MessageContent messageContent, FrontiaPushListener.CommonMessageListener commonMessageListener) {
        this.b.replaceMessage(str, str2, trigger.a(), messageContent.a(), new a(commonMessageListener).a());
    }

    public void replaceMessage(String str, String str2, String str3, FrontiaPushUtil.Trigger trigger, FrontiaPushUtil.MessageContent messageContent, FrontiaPushListener.CommonMessageListener commonMessageListener) {
        this.b.replaceMessage(str, str2, str3, trigger.a(), messageContent.a(), new a(commonMessageListener).a());
    }

    public void resume() {
        PushManager.resumeWork(this.c);
    }

    public void setDebugModeEnabled(boolean z) {
        PushSettings.enableDebugMode(this.c, z);
    }

    public void setNotificationBuilder(int i, FrontiaPushUtil.a aVar) {
        if (aVar != null) {
            PushManager.setNotificationBuilder(this.c, i, aVar.a());
        }
    }

    public void setTags(List<String> list) {
        this.b.setTags(list);
    }

    public void start() {
        this.b.start();
    }

    public void start(String str) {
        this.b.start(str);
    }

    public void stop() {
        PushManager.stopWork(this.c);
        StatUtils.insertBehavior(this.c, "010702", 0, "", "", System.currentTimeMillis());
    }
}

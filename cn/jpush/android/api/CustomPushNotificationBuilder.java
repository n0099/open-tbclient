package cn.jpush.android.api;

import android.content.Context;
import android.widget.RemoteViews;
/* loaded from: classes3.dex */
public class CustomPushNotificationBuilder extends BasicPushNotificationBuilder {
    private int b;
    public int layout;
    public int layoutContentId;
    public int layoutIconDrawable;
    public int layoutIconId;
    public int layoutTitleId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomPushNotificationBuilder(Context context) {
        super(context);
        this.layoutIconDrawable = cn.jpush.android.a.b;
    }

    public CustomPushNotificationBuilder(Context context, int i, int i2, int i3, int i4) {
        super(context);
        this.layoutIconDrawable = cn.jpush.android.a.b;
        this.layout = i;
        this.layoutIconId = i2;
        this.layoutTitleId = i3;
        this.layoutContentId = i4;
    }

    @Override // cn.jpush.android.api.BasicPushNotificationBuilder
    final String a() {
        return super.a() + "_____" + this.layout + "_____" + this.layoutIconId + "_____" + this.layoutTitleId + "_____" + this.layoutContentId + "_____" + this.layoutIconDrawable + "_____" + this.b;
    }

    @Override // cn.jpush.android.api.BasicPushNotificationBuilder
    final void a(String[] strArr) {
        super.a(strArr);
        this.layout = Integer.parseInt(strArr[5]);
        this.layoutIconId = Integer.parseInt(strArr[6]);
        this.layoutTitleId = Integer.parseInt(strArr[7]);
        this.layoutContentId = Integer.parseInt(strArr[8]);
        this.layoutIconDrawable = Integer.parseInt(strArr[9]);
        if (strArr.length == 11) {
            this.b = Integer.parseInt(strArr[10]);
        }
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    RemoteViews buildContentView(String str, String str2) {
        RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), this.layout);
        remoteViews.setTextViewText(this.layoutTitleId, str2);
        remoteViews.setImageViewResource(this.layoutIconId, this.layoutIconDrawable);
        remoteViews.setTextViewText(this.layoutContentId, str);
        if (this.b != 0) {
            remoteViews.setLong(this.b, "setTime", System.currentTimeMillis());
        }
        return remoteViews;
    }

    @Override // cn.jpush.android.api.BasicPushNotificationBuilder, cn.jpush.android.api.DefaultPushNotificationBuilder
    public String toString() {
        return "custom_____" + a();
    }
}

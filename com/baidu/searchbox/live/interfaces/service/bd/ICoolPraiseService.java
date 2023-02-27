package com.baidu.searchbox.live.interfaces.service.bd;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.live.interfaces.praise.PraiseClickListener;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\u000bJ\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0019H&¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0019H&¢\u0006\u0004\b \u0010\u001c¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/bd/ICoolPraiseService;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "Landroid/view/View;", "getView", "(Landroid/content/Context;)Landroid/view/View;", "", "isNight", "", "setImage", "(Z)V", "Lcom/baidu/searchbox/live/interfaces/praise/PraiseClickListener;", "l", "setOnClickPraiseListener", "(Lcom/baidu/searchbox/live/interfaces/praise/PraiseClickListener;)V", "checked", "setPraise", RemoteMessageConst.Notification.VISIBILITY, "setPraiseCntsVisibility", "", "width", "height", "setPraiseIconSize", "(II)V", "", "id", "setPraiseId", "(Ljava/lang/String;)V", "praiseSource", "setPraiseSource", "ubcSource", "setUBC", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ICoolPraiseService {
    View getView(Context context);

    void setImage(boolean z);

    void setOnClickPraiseListener(PraiseClickListener praiseClickListener);

    void setPraise(boolean z);

    void setPraiseCntsVisibility(boolean z);

    void setPraiseIconSize(int i, int i2);

    void setPraiseId(String str);

    void setPraiseSource(String str);

    void setUBC(String str);
}

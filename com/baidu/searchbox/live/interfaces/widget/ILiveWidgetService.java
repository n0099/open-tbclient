package com.baidu.searchbox.live.interfaces.widget;

import android.app.Activity;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012J9\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/widget/ILiveWidgetService;", "Lkotlin/Any;", "Landroid/app/Activity;", "activity", "", "widgetId", "", "params", "static", "Lcom/baidu/searchbox/live/interfaces/widget/ILiveWidgetService$IWidgetCallBack;", "widgetCallBack", "", "addWidget", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/widget/ILiveWidgetService$IWidgetCallBack;)V", "", "hasLiveWidget", "(Landroid/app/Activity;J)Z", "Companion", "IWidgetCallBack", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ILiveWidgetService {
    public static final Companion Companion = Companion.$$INSTANCE;

    void addWidget(Activity activity, long j, String str, String str2, IWidgetCallBack iWidgetCallBack);

    boolean hasLiveWidget(Activity activity, long j);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/widget/ILiveWidgetService$IWidgetCallBack;", "Lkotlin/Any;", "", "widgetId", "Lorg/json/JSONObject;", "widgetInfo", "", "onAddSuccess", "(JLorg/json/JSONObject;)V", "", "errorCode", "", "message", "onFailure", "(ILjava/lang/String;)V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface IWidgetCallBack {
        public static final Companion Companion = Companion.$$INSTANCE;

        void onAddSuccess(long j, JSONObject jSONObject);

        void onFailure(int i, String str);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/widget/ILiveWidgetService$IWidgetCallBack$Companion;", "", "OK_CODE", "I", "getOK_CODE", "()I", "WIDGET_CANCEL_CODE", "getWIDGET_CANCEL_CODE", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes2.dex */
        public static final class Companion {
            public static final int OK_CODE = 0;
            public static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int WIDGET_CANCEL_CODE = 1003;

            public final int getOK_CODE() {
                return OK_CODE;
            }

            public final int getWIDGET_CANCEL_CODE() {
                return WIDGET_CANCEL_CODE;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/widget/ILiveWidgetService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.BD.LIVE_WIDGET);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}

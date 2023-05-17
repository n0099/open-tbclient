package com.baidu.searchbox.vip;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.vip.models.VipUserInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 -2\u00020\u0001:\u0001-J7\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052#\b\u0001\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0007H&J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J7\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052#\b\u0001\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0007H&J8\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019H&J8\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019H&Jy\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u001d\u001a\u00020\u00052#\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000728\u0010 \u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0003\u0018\u00010!H&J[\u0010#\u001a\u00020\u00032Q\b\u0001\u0010$\u001aK\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00030%H&J8\u0010(\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00052\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019H&J\b\u0010,\u001a\u00020\u0003H&¨\u0006."}, d2 = {"Lcom/baidu/searchbox/vip/IVipUserInfoManager;", "", "getEquitiesFreeNum", "", "equitiesType", "", "equitiesCallBack", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "freeNum", "getHasDuVip", "", "getHasVipUnionType", "type", "getVipUserInfo", "Lcom/baidu/searchbox/vip/models/VipUserInfo;", "reduceEquitiesFreeNum", "reduceCallBack", "requestBDPanVipVideoCase", "context", "Landroid/content/Context;", "buyType", "successCallback", "Lkotlin/Function0;", "failCallback", "requestBuyBDPanVip", "requestCommonBuyVip", "buyScheme", "vipBuySuccessCb", "buyVipType", "vipBuyFailCb", "Lkotlin/Function2;", StatConstants.KEY_EXT_ERR_CODE, "requestGetTempVip", "tempVipCallback", "Lkotlin/Function3;", "resultCode", StatConstants.KEY_EXT_ERR_MSG, "showActiveVipDialog", "message", "vipActiveSuccessCb", "vipActiveFailCb", "syncVipUserInfo", "Companion", "lib-vip-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IVipUserInfoManager {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String NAME = "VIP";
    public static final String NAME_SPACE = "vip";

    void getEquitiesFreeNum(String str, Function1<? super Integer, Unit> function1);

    boolean getHasDuVip();

    boolean getHasVipUnionType(String str);

    VipUserInfo getVipUserInfo();

    void reduceEquitiesFreeNum(String str, Function1<? super Integer, Unit> function1);

    void requestBDPanVipVideoCase(Context context, int i, Function0<Unit> function0, Function0<Unit> function02);

    void requestBuyBDPanVip(Context context, int i, Function0<Unit> function0, Function0<Unit> function02);

    void requestCommonBuyVip(Context context, String str, Function1<? super String, Unit> function1, Function2<? super String, ? super Integer, Unit> function2);

    void requestGetTempVip(Function3<? super Integer, ? super String, ? super String, Unit> function3);

    void showActiveVipDialog(Context context, String str, Function0<Unit> function0, Function0<Unit> function02);

    void syncVipUserInfo();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/vip/IVipUserInfoManager$Companion;", "", "()V", "NAME", "", "NAME_SPACE", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "lib-vip-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final String NAME = "VIP";
        public static final String NAME_SPACE = "vip";
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("vip", "VIP");

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}

package com.baidu.searchbox.live.interfaces.mix;

import android.view.View;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u0010J9\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0018\u0010\u0017J#\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/mix/IMixShellInterface;", "Lkotlin/Any;", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "Lorg/json/JSONObject;", "extObj", "onCreateView", "(Landroid/view/View;Lorg/json/JSONObject;)Landroid/view/View;", "", "onLiveAttach", "(Landroid/view/View;Lorg/json/JSONObject;)V", "Lcom/baidu/searchbox/live/interfaces/mix/BaseItemModel;", "model", "onLiveBindData", "(Landroid/view/View;Lcom/baidu/searchbox/live/interfaces/mix/BaseItemModel;Lorg/json/JSONObject;)V", "onLiveDeselected", "()V", "onLiveDetach", "", CriusAttrConstants.POSITION, "", "isFromUser", "onLiveSelected", "(Landroid/view/View;ILcom/baidu/searchbox/live/interfaces/mix/BaseItemModel;ZLorg/json/JSONObject;)V", "onPageSelected", "", "key", "", "ext", "setMixEventDispatcher", "(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;", "Lcom/baidu/searchbox/live/interfaces/mix/MixInvokeAbility;", "ability", "setMixInvokeAbility", "(Lcom/baidu/searchbox/live/interfaces/mix/MixInvokeAbility;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface IMixShellInterface {
    View onCreateView(View view2, JSONObject jSONObject);

    void onLiveAttach(View view2, JSONObject jSONObject);

    void onLiveBindData(View view2, BaseItemModel baseItemModel, JSONObject jSONObject);

    void onLiveDeselected();

    void onLiveDetach();

    void onLiveSelected(View view2, int i, BaseItemModel baseItemModel, boolean z, JSONObject jSONObject);

    void onPageSelected(View view2, int i, BaseItemModel baseItemModel, boolean z, JSONObject jSONObject);

    JSONObject setMixEventDispatcher(String str, Object obj);

    void setMixInvokeAbility(MixInvokeAbility mixInvokeAbility);
}

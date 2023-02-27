package com.baidu.searchbox.live.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.arch.frame.State;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.interfaces.mix.BaseItemModel;
import com.baidu.searchbox.live.interfaces.mix.BasePlaySourceInfo;
import com.baidu.searchbox.live.interfaces.mix.BaseRuntimeStatus;
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0004 !\"#B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\r\u0010\bJ%\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/live/widget/LiveContainer;", "Landroid/widget/FrameLayout;", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "model", "", "bindData", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "onAttachedToWindow", "()V", "", CriusAttrConstants.POSITION, "onDeselected", "(ILcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "onDetachedFromWindow", "", "isFromUser", "onSelected", "(ILcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;Z)V", "Lcom/baidu/searchbox/live/widget/LiveContainer$ViewAttachListener;", "attachListener", "Lcom/baidu/searchbox/live/widget/LiveContainer$ViewAttachListener;", "getAttachListener", "()Lcom/baidu/searchbox/live/widget/LiveContainer$ViewAttachListener;", "setAttachListener", "(Lcom/baidu/searchbox/live/widget/LiveContainer$ViewAttachListener;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LiveItemModel", "LiveRuntimeStatus", "PlaySourceInfo", "ViewAttachListener", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class LiveContainer extends FrameLayout {
    public HashMap _$_findViewCache;
    public ViewAttachListener attachListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/live/widget/LiveContainer$LiveRuntimeStatus;", "Lcom/baidu/searchbox/live/interfaces/mix/BaseRuntimeStatus;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class LiveRuntimeStatus extends BaseRuntimeStatus {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/live/widget/LiveContainer$PlaySourceInfo;", "Lcom/baidu/searchbox/live/interfaces/mix/BasePlaySourceInfo;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class PlaySourceInfo extends BasePlaySourceInfo {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J'\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/widget/LiveContainer$ViewAttachListener;", "Lkotlin/Any;", "", "onAttach", "()V", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "model", "onDataChanged", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "", CriusAttrConstants.POSITION, "onDeselected", "(ILcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "onDetach", "", "isFromUser", "onSelected", "(ILcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;Z)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface ViewAttachListener {
        void onAttach();

        void onDataChanged(LiveItemModel liveItemModel);

        void onDeselected(int i, LiveItemModel liveItemModel);

        void onDetach();

        void onSelected(int i, LiveItemModel liveItemModel, boolean z);
    }

    @JvmOverloads
    public LiveContainer(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public LiveContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view2 == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0007¢\u0006\u0004\b#\u0010\fJ\u0017\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\r\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\nJ\r\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\nJ\r\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\nJ\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\nJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\nJ\r\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\nJ\r\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\nJ\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\nJ\r\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010\nJ\r\u0010 \u001a\u00020\b¢\u0006\u0004\b \u0010\nJ\r\u0010!\u001a\u00020\b¢\u0006\u0004\b!\u0010\nJ\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\u0015¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "Lcom/baidu/live/arch/frame/State;", "Lcom/baidu/searchbox/live/interfaces/mix/BaseItemModel;", "", "roomId", "", "bindJumpNewLiveRoomId", "(Ljava/lang/String;)V", "", MediaLivePlayLogger.KEY_CAN_PRE_PLAY, "()Z", "clearIntroduceTips", "()V", "", ImageViewerConfig.FROM_OTHER, "equals", "(Ljava/lang/Object;)Z", "", "getIntroduceTipsStatus", "()I", "getJumpNewLiveRoomId", "()Ljava/lang/String;", TTDownloadField.TT_HASHCODE, "isAudioLive", "isConsultLive", "isFullTemplate", "isHLReplay", "isInValid", "isMediaBusiness", "isMediaLive", "isNewMediaLive", "isStarVertical", "isVideoLand", "isYYLive", "toString", "<init>", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class LiveItemModel extends BaseItemModel implements State {
        public static final Companion Companion = new Companion(null);
        public static final String KEY = "LiveItemModel";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel$Companion;", "", "KEY", "Ljava/lang/String;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes2.dex */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final boolean canPrePlay() {
            return Intrinsics.areEqual(getLiveType(), "0");
        }

        public final void clearIntroduceTips() {
            setIntroduceTips(null);
        }

        public final int getIntroduceTipsStatus() {
            JSONObject introduceTips = getIntroduceTips();
            if (introduceTips == null) {
                return -1;
            }
            return introduceTips.optInt("status", -1);
        }

        public final String getJumpNewLiveRoomId() {
            if (getHlReplay() == null) {
                return "";
            }
            JSONObject hlReplay = getHlReplay();
            if (hlReplay == null) {
                Intrinsics.throwNpe();
            }
            String optString = hlReplay.optString("jumpRoomId");
            Intrinsics.checkExpressionValueIsNotNull(optString, "hlReplay!!.optString(\"jumpRoomId\")");
            return optString;
        }

        public int hashCode() {
            return getRoomId().hashCode();
        }

        public final boolean isAudioLive() {
            if (Intrinsics.areEqual(getLiveType(), "0") && Intrinsics.areEqual(getTemplateId(), "5")) {
                return true;
            }
            return false;
        }

        public final boolean isConsultLive() {
            if (Intrinsics.areEqual(getLiveType(), "0") && Intrinsics.areEqual(getTemplateId(), "3")) {
                return true;
            }
            return false;
        }

        public final boolean isFullTemplate() {
            return Intrinsics.areEqual(String.valueOf(1), getTemplate());
        }

        public final boolean isHLReplay() {
            if (getHlReplay() != null) {
                return true;
            }
            return false;
        }

        public final boolean isInValid() {
            if (!TextUtils.isEmpty(getScreen()) && !TextUtils.isEmpty(getTemplate())) {
                return true;
            }
            return false;
        }

        public final boolean isMediaBusiness() {
            return Intrinsics.areEqual(getLiveType(), "0");
        }

        public final boolean isMediaLive() {
            if (Intrinsics.areEqual(getLiveType(), "0") && Intrinsics.areEqual(getTemplateId(), "0")) {
                return true;
            }
            return false;
        }

        public final boolean isNewMediaLive() {
            if (Intrinsics.areEqual(getLiveType(), "0") && Intrinsics.areEqual(getTemplateId(), "1")) {
                return true;
            }
            return false;
        }

        public final boolean isStarVertical() {
            if (!isVideoLand() && isFullTemplate()) {
                return true;
            }
            return false;
        }

        public final boolean isVideoLand() {
            return Intrinsics.areEqual(String.valueOf(1), getScreen());
        }

        public final boolean isYYLive() {
            return Intrinsics.areEqual(getLiveType(), "3");
        }

        public final void bindJumpNewLiveRoomId(String str) {
            boolean z;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            if (getHlReplay() == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("jumpRoomId", str);
                setHlReplay(jSONObject);
                return;
            }
            JSONObject hlReplay = getHlReplay();
            if (hlReplay == null) {
                Intrinsics.throwNpe();
            }
            hlReplay.put("jumpRoomId", str);
        }

        public boolean equals(Object obj) {
            Class<?> cls;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(LiveItemModel.class, cls)) {
                return false;
            }
            if (obj != null) {
                if (!(!Intrinsics.areEqual(getRoomId(), ((LiveItemModel) obj).getRoomId()))) {
                    return true;
                }
                return false;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.searchbox.live.widget.LiveContainer.LiveItemModel");
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("room_id", getRoomId());
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, getCover());
            jSONObject.put("play_url", getPlayUrl());
            jSONObject.put("live_type", getLiveType());
            jSONObject.put("scheme", getScheme());
            jSONObject.put("bgCover", getBgCover());
            jSONObject.put("title", getTitle());
            jSONObject.put("cRoomId", getCRoomId());
            JSONObject otherParams = getOtherParams();
            if (otherParams != null) {
                jSONObject.put("otherParams", otherParams);
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "json.toString()");
            return jSONObject2;
        }
    }

    @JvmOverloads
    public LiveContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onSelected(int i, LiveItemModel liveItemModel, boolean z) {
        ViewAttachListener viewAttachListener = this.attachListener;
        if (viewAttachListener != null) {
            viewAttachListener.onSelected(i, liveItemModel, z);
        }
    }

    public /* synthetic */ LiveContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void bindData(LiveItemModel liveItemModel) {
        ViewAttachListener viewAttachListener = this.attachListener;
        if (viewAttachListener != null) {
            viewAttachListener.onDataChanged(liveItemModel);
        }
    }

    public final void setAttachListener(ViewAttachListener viewAttachListener) {
        this.attachListener = viewAttachListener;
    }

    public final ViewAttachListener getAttachListener() {
        return this.attachListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewAttachListener viewAttachListener = this.attachListener;
        if (viewAttachListener != null) {
            viewAttachListener.onAttach();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewAttachListener viewAttachListener = this.attachListener;
        if (viewAttachListener != null) {
            viewAttachListener.onDetach();
        }
    }

    public final void onDeselected(int i, LiveItemModel liveItemModel) {
        ViewAttachListener viewAttachListener = this.attachListener;
        if (viewAttachListener != null) {
            viewAttachListener.onDeselected(i, liveItemModel);
        }
    }
}

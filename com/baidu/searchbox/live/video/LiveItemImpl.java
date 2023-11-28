package com.baidu.searchbox.live.video;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.host2live.video.ILiveItem;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.shell.list.basic.MixBasicFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixConsultFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixMediaFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixNewMediaFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixShopFakeShell;
import com.baidu.searchbox.live.ubc.LiveComponentLoadLogger;
import com.baidu.searchbox.live.video.LiveActInterfaceImpl;
import com.baidu.searchbox.live.video.LiveItemImpl;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 O2\u00020\u0001:\u0002OPB3\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u00107\u001a\u00020$\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\bM\u0010NJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010!\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b!\u0010\"J-\u0010(\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u000e\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)R\u0019\u0010+\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0019\u00100\u001a\u00020/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00104\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u000bR\u0016\u00107\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\"\u00109\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001b\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001d\u0010G\u001a\u00020\f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u000eR\u0019\u0010I\u001a\u00020H8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L¨\u0006Q"}, d2 = {"Lcom/baidu/searchbox/live/video/LiveItemImpl;", "Lcom/baidu/searchbox/live/host2live/video/ILiveItem;", "", CriusAttrConstants.POSITION, "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "createItemView", "(ILandroid/view/ViewGroup;)Landroid/view/View;", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "getSchemeModel", "()Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "Lcom/baidu/searchbox/live/shell/list/basic/MixBasicFakeShell;", "getSchemeShell", "()Lcom/baidu/searchbox/live/shell/list/basic/MixBasicFakeShell;", AiBotChatDispatcher.AI_SINGLE_REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "view", "onLiveSelected", "(ILandroid/view/View;)V", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "mixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "getMixActivity", "()Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "model", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "getModel", "roomScheme", "Ljava/lang/String;", "selected", "Z", "getSelected", "()Z", "setSelected", "(Z)V", "Lcom/baidu/searchbox/live/video/LiveItemImpl$ILiveItemStateChangCallback;", "selectedCallback", "Lcom/baidu/searchbox/live/video/LiveItemImpl$ILiveItemStateChangCallback;", "getSelectedCallback", "()Lcom/baidu/searchbox/live/video/LiveItemImpl$ILiveItemStateChangCallback;", "shell$delegate", "Lkotlin/Lazy;", "getShell", "shell", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "uniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "getUniqueId", "()Lcom/baidu/live/arch/utils/MiniUniqueId;", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Lcom/baidu/live/arch/utils/MiniUniqueId;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;Lcom/baidu/searchbox/live/video/LiveItemImpl$ILiveItemStateChangCallback;)V", "Companion", "ILiveItemStateChangCallback", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class LiveItemImpl implements ILiveItem {
    public static final String ACTION_ENTER_FUSION_ROOM = "/enterStreamRoom";
    public static final String ACTION_ENTER_VIDEO_ROOM = "/enterRoom";
    public static final String ACTION_ENTER_VIDEO_ROOM_HOST = "live";
    public final Activity activity;
    public final IMixActivityInterface mixActivity;
    public final LiveContainer.LiveItemModel model;
    public final String roomScheme;
    public boolean selected;
    public final ILiveItemStateChangCallback selectedCallback;
    public final Lazy shell$delegate;
    public final MiniUniqueId uniqueId;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveItemImpl.class), "shell", "getShell()Lcom/baidu/searchbox/live/shell/list/basic/MixBasicFakeShell;"))};
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/video/LiveItemImpl$ILiveItemStateChangCallback;", "Lkotlin/Any;", "", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "Lcom/baidu/searchbox/live/video/LiveItemImpl;", "liveItemImpl", "", "onSelectedStateChanged", "(ZLcom/baidu/searchbox/live/video/LiveItemImpl;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public interface ILiveItemStateChangCallback {
        void onSelectedStateChanged(boolean z, LiveItemImpl liveItemImpl);
    }

    public final MixBasicFakeShell getShell() {
        Lazy lazy = this.shell$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (MixBasicFakeShell) lazy.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/video/LiveItemImpl$Companion;", "", "ACTION_ENTER_FUSION_ROOM", "Ljava/lang/String;", "ACTION_ENTER_VIDEO_ROOM", "ACTION_ENTER_VIDEO_ROOM_HOST", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LiveItemImpl(Activity activity, String str, MiniUniqueId miniUniqueId, IMixActivityInterface iMixActivityInterface, ILiveItemStateChangCallback iLiveItemStateChangCallback) {
        this.activity = activity;
        this.roomScheme = str;
        this.uniqueId = miniUniqueId;
        this.mixActivity = iMixActivityInterface;
        this.selectedCallback = iLiveItemStateChangCallback;
        this.shell$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MixBasicFakeShell>() { // from class: com.baidu.searchbox.live.video.LiveItemImpl$shell$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MixBasicFakeShell invoke() {
                MixBasicFakeShell schemeShell;
                schemeShell = LiveItemImpl.this.getSchemeShell();
                return schemeShell;
            }
        });
        this.model = getSchemeModel();
    }

    public /* synthetic */ LiveItemImpl(Activity activity, String str, MiniUniqueId miniUniqueId, IMixActivityInterface iMixActivityInterface, ILiveItemStateChangCallback iLiveItemStateChangCallback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, str, miniUniqueId, iMixActivityInterface, (i & 16) != 0 ? null : iLiveItemStateChangCallback);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        LiveActInterfaceImpl.Companion.log("LiveItemImpl onConfigurationChanged");
        if (configuration != null) {
            getShell().onConfigurationChanged(configuration);
        }
        LiveActInterfaceImpl.Companion.log("LiveItemImpl end");
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    private final LiveContainer.LiveItemModel getSchemeModel() {
        String str;
        LiveActInterfaceImpl.Companion.log("LiveItemImpl getSchemeModel: " + this.roomScheme);
        Uri parse = Uri.parse(this.roomScheme);
        if (parse != null) {
            str = parse.getHost();
        } else {
            str = null;
        }
        if (str != null && parse.getPath() != null && Intrinsics.areEqual("live", parse.getHost()) && (Intrinsics.areEqual(parse.getPath(), ACTION_ENTER_VIDEO_ROOM) || Intrinsics.areEqual(parse.getPath(), ACTION_ENTER_FUSION_ROOM))) {
            LiveActInterfaceImpl.Companion.log("LiveItemImpl getSchemeModel: scheme 是直播的，开始解析参数");
            try {
                String queryParameter = parse.getQueryParameter("params");
                String str2 = "";
                if (queryParameter == null) {
                    queryParameter = "";
                }
                Intrinsics.checkExpressionValueIsNotNull(queryParameter, "uri.getQueryParameter(\"params\") ?: \"\"");
                IntentData.SchemeModel parseSchemeData = IntentData.Companion.parseSchemeData(queryParameter, this.roomScheme);
                LiveActInterfaceImpl.Companion.log("LiveItemImpl getSchemeModel: scheme 是直播的，构建直播 " + parseSchemeData);
                LiveContainer.LiveItemModel liveItemModel = new LiveContainer.LiveItemModel();
                liveItemModel.setRoomId(parseSchemeData.getRoomId());
                liveItemModel.setCover(parseSchemeData.getCover());
                String roomType = parseSchemeData.getRoomType();
                if (roomType == null) {
                    roomType = "0";
                }
                liveItemModel.setLiveType(roomType);
                liveItemModel.setScheme(this.roomScheme);
                liveItemModel.setPlayUrl(parseSchemeData.getPlayUrl());
                liveItemModel.setStatus(parseSchemeData.getStatus());
                liveItemModel.setFormat(parseSchemeData.getFormat());
                liveItemModel.setScreen(parseSchemeData.getScreen());
                liveItemModel.setTemplate(parseSchemeData.getTemplate());
                liveItemModel.setTemplateId(parseSchemeData.getTemplateId());
                String title = parseSchemeData.getTitle();
                if (title != null) {
                    str2 = title;
                }
                liveItemModel.setTitle(str2);
                liveItemModel.setOtherParams(parseSchemeData.getOtherParams());
                liveItemModel.setAvcUrl(parseSchemeData.getAvcUrl());
                liveItemModel.setHevcUrl(parseSchemeData.getHevcUrl());
                liveItemModel.setRtcUrl(parseSchemeData.getRtcUrl());
                liveItemModel.setRtcHevcUrl(parseSchemeData.getRtcHevcUrl());
                liveItemModel.setQuic(parseSchemeData.getQuic());
                liveItemModel.setHighlightUrl(parseSchemeData.getHighlightUrl());
                liveItemModel.setExt(parseSchemeData.getExt());
                liveItemModel.setSource(parseSchemeData.getSource());
                liveItemModel.setShareTaskInfo(parseSchemeData.getShareTaskInfo());
                liveItemModel.setKabrSpts(parseSchemeData.getKabrSpts());
                liveItemModel.setCommonShareInfo(parseSchemeData.getCommonShareInfo());
                liveItemModel.setMultiRate(parseSchemeData.getMultiRate());
                liveItemModel.setFromIntent(parseSchemeData.getFromIntent());
                liveItemModel.setVrParams(parseSchemeData.getVrParams());
                liveItemModel.setPlayRateSetting(parseSchemeData.getPlayRateSetting());
                liveItemModel.setInterventions(parseSchemeData.getInterventions());
                return liveItemModel;
            } catch (Exception e) {
                LiveActInterfaceImpl.Companion.log("LiveItemImpl getSchemeModel: scheme 参数解析异常：" + e.getMessage());
            }
        }
        LiveActInterfaceImpl.Companion.log("LiveItemImpl getSchemeModel: scheme 校验不通过，model 构建失败");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MixBasicFakeShell getSchemeShell() {
        String str;
        LiveActInterfaceImpl.Companion companion = LiveActInterfaceImpl.Companion;
        StringBuilder sb = new StringBuilder();
        sb.append("LiveItemImpl getSchemeShell model: ");
        LiveContainer.LiveItemModel liveItemModel = this.model;
        if (liveItemModel != null) {
            str = liveItemModel.getTemplateId();
        } else {
            str = null;
        }
        sb.append(str);
        companion.log(sb.toString());
        LiveContainer.LiveItemModel liveItemModel2 = this.model;
        int i = (liveItemModel2 == null || (i = liveItemModel2.getTemplateId()) == null) ? 0 : 0;
        if (Intrinsics.areEqual(i, (Object) 3)) {
            return new MixNewMediaFakeShell(this.activity, this.uniqueId, this.mixActivity);
        }
        if (Intrinsics.areEqual(i, (Object) 4)) {
            return new MixShopFakeShell(this.activity, this.uniqueId, this.mixActivity);
        }
        if (Intrinsics.areEqual(i, MixConstants.LIVE_COMPONENT_CONSULT)) {
            return new MixConsultFakeShell(this.activity, this.uniqueId, this.mixActivity);
        }
        return new MixMediaFakeShell(this.activity, this.uniqueId, this.mixActivity);
    }

    @Override // com.baidu.searchbox.live.host2live.video.ILiveItem
    public View createItemView(int i, ViewGroup viewGroup) {
        LiveActInterfaceImpl.Companion companion = LiveActInterfaceImpl.Companion;
        companion.log("LiveItemImpl createItemView model: " + this.model);
        if (this.model == null) {
            return null;
        }
        final View createContainerView = getShell().createContainerView();
        LiveActInterfaceImpl.Companion companion2 = LiveActInterfaceImpl.Companion;
        companion2.log("LiveItemImpl createItemView itemView: " + createContainerView);
        getShell().onLiveBindData(this.model);
        LiveActInterfaceImpl.Companion.log("LiveItemImpl shell onLiveBindData end");
        createContainerView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.searchbox.live.video.LiveItemImpl$createItemView$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                LiveActInterfaceImpl.Companion companion3 = LiveActInterfaceImpl.Companion;
                companion3.log("LiveItemImpl onViewAttachedToWindow model: " + LiveItemImpl.this.getModel());
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                LiveActInterfaceImpl.Companion companion3 = LiveActInterfaceImpl.Companion;
                companion3.log("LiveItemImpl onViewDetachedFromWindow selected: " + LiveItemImpl.this.getSelected() + " , model: " + LiveItemImpl.this.getModel());
                createContainerView.removeOnAttachStateChangeListener(this);
                if (LiveItemImpl.this.getSelected()) {
                    LiveItemImpl.ILiveItemStateChangCallback selectedCallback = LiveItemImpl.this.getSelectedCallback();
                    if (selectedCallback != null) {
                        selectedCallback.onSelectedStateChanged(false, LiveItemImpl.this);
                    }
                    LiveItemImpl.this.getShell().onLiveDeselected();
                }
                LiveItemImpl.this.setSelected(false);
                LiveActInterfaceImpl.Companion.log("LiveItemImpl shell onLiveDeselected end");
            }
        });
        LiveActInterfaceImpl.Companion.log("LiveItemImpl createItemView itemView 创建成功，返回");
        return createContainerView;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        Boolean bool;
        LiveActInterfaceImpl.Companion companion = LiveActInterfaceImpl.Companion;
        companion.log("LiveItemImpl onKeyDown: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + keyEvent);
        if (keyEvent != null) {
            bool = Boolean.valueOf(getShell().onKeyDown(i, keyEvent));
        } else {
            bool = null;
        }
        LiveActInterfaceImpl.Companion companion2 = LiveActInterfaceImpl.Companion;
        companion2.log("LiveItemImpl onKeyDown: end, " + bool);
        return Intrinsics.areEqual(bool, Boolean.TRUE);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final IMixActivityInterface getMixActivity() {
        return this.mixActivity;
    }

    public final LiveContainer.LiveItemModel getModel() {
        return this.model;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final ILiveItemStateChangCallback getSelectedCallback() {
        return this.selectedCallback;
    }

    public final MiniUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        LiveActInterfaceImpl.Companion companion = LiveActInterfaceImpl.Companion;
        companion.log("LiveItemImpl onActivityResult " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2);
        getShell().onActivityResult(i, i2, intent);
        LiveActInterfaceImpl.Companion companion2 = LiveActInterfaceImpl.Companion;
        companion2.log("LiveItemImpl onActivityResult " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2);
    }

    @Override // com.baidu.searchbox.live.host2live.video.ILiveItem
    public void onLiveSelected(int i, View view2) {
        String str;
        ILiveItemStateChangCallback iLiveItemStateChangCallback = this.selectedCallback;
        if (iLiveItemStateChangCallback != null) {
            iLiveItemStateChangCallback.onSelectedStateChanged(true, this);
        }
        LiveActInterfaceImpl.Companion.log("LiveItemImpl onLiveSelected position: " + i + "， model: " + this.model);
        if (this.selected) {
            LiveActInterfaceImpl.Companion.log("LiveItemImpl onLiveSelected 已是选中状态，不再重复调用到直播间");
            return;
        }
        this.selected = true;
        LiveContainer.LiveItemModel liveItemModel = this.model;
        if (liveItemModel != null) {
            LiveComponentLoadLogger companion = LiveComponentLoadLogger.Companion.getInstance();
            String str2 = null;
            if (liveItemModel != null) {
                str = liveItemModel.getRoomId();
            } else {
                str = null;
            }
            String str3 = (liveItemModel == null || (str3 = liveItemModel.getTemplateId()) == null) ? "" : "";
            if (liveItemModel != null) {
                str2 = liveItemModel.getSource();
            }
            companion.launchMediaCompLoadFlow(str, str3, true, str2);
            getShell().onPageSelected(i, liveItemModel, true);
            LiveActInterfaceImpl.Companion.log("LiveItemImpl shell onPageSelected end");
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        LiveActInterfaceImpl.Companion companion = LiveActInterfaceImpl.Companion;
        companion.log("LiveItemImpl onRequestPermissionsResult " + i);
        getShell().onRequestPermissionsResult(i, strArr, iArr);
        LiveActInterfaceImpl.Companion.log("LiveItemImpl onRequestPermissionsResult end");
    }
}

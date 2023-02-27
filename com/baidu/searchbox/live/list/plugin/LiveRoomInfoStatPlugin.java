package com.baidu.searchbox.live.list.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.transition.Transition;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.api.IService;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.searchbox.live.list.plugin.LiveRoomInfoStatPlugin;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.searchbox.player.utils.SharedPrefsWrapper;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *:\u0005*+,-.B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b(\u0010)J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\r\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR2\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001cj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d`\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0018\u0010\u0012\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010'¨\u0006/"}, d2 = {"Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin;", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "liveItemModel", "", "dispatchFirstLiveItemModelAction", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "", "pageSession", "", "hasMore", "", "data", "dispatchListResult", "(Ljava/lang/String;ILjava/util/List;)V", "dispatchLiveItemModelSelectedAction", "onCreate", "()V", MissionEvent.MESSAGE_DESTROY, "recoveryUploadIds", "registerService", "saveUploadIds", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentRoomId", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$LiveItemModelWrapper;", "Lkotlin/collections/HashMap;", "liveItemModels", "Ljava/util/HashMap;", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "getMixUniqueId", "()Lcom/baidu/live/arch/utils/MiniUniqueId;", "Lorg/json/JSONArray;", "Lorg/json/JSONArray;", "<init>", "(Landroid/content/Context;Lcom/baidu/live/arch/utils/MiniUniqueId;)V", "Companion", "DisplayPart", "LiveItemModelWrapper", "LiveRoomInfoStatPreferences", com.baidu.sapi2.utils.StatService.TAG, "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveRoomInfoStatPlugin {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "LiveRoomInfoStatPlugin";
    public final Context context;
    public String currentRoomId;
    public final HashMap<String, LiveItemModelWrapper> liveItemModels = new HashMap<>();
    public final MiniUniqueId mixUniqueId;
    public JSONArray recoveryUploadIds;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$StatService;", "Lcom/baidu/live/arch/api/IService;", "Lkotlin/Any;", "Lorg/json/JSONArray;", "getUploadIds", "()Lorg/json/JSONArray;", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface StatService extends IService {
        JSONArray getUploadIds();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$LiveRoomInfoStatPreferences;", "Lcom/baidu/searchbox/player/utils/SharedPrefsWrapper;", "Landroid/content/Context;", "context", "", CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME, "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Companion", "Holder", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class LiveRoomInfoStatPreferences extends SharedPrefsWrapper {
        public static final Companion Companion = new Companion(null);
        public static final String PREF_NAME = "live_room_info_stat";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0007\u001a\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$LiveRoomInfoStatPreferences$Companion;", "", "PREF_NAME", "Ljava/lang/String;", "Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$LiveRoomInfoStatPreferences;", "getInstance", "()Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$LiveRoomInfoStatPreferences;", Transition.MATCH_INSTANCE_STR, "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes2.dex */
        public static final class Companion {
            public Companion() {
            }

            public final LiveRoomInfoStatPreferences getInstance() {
                return Holder.INSTANCE.getINSTANCE();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÂ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$LiveRoomInfoStatPreferences$Holder;", "Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$LiveRoomInfoStatPreferences;", "INSTANCE", "Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$LiveRoomInfoStatPreferences;", "getINSTANCE", "()Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$LiveRoomInfoStatPreferences;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes2.dex */
        public static final class Holder {
            public static final Holder INSTANCE = new Holder();

            /* renamed from: INSTANCE  reason: collision with other field name */
            public static final LiveRoomInfoStatPreferences f3INSTANCE = new LiveRoomInfoStatPreferences(MiniShellRuntime.INSTANCE.getAppContext(), LiveRoomInfoStatPreferences.PREF_NAME, null);

            public final LiveRoomInfoStatPreferences getINSTANCE() {
                return f3INSTANCE;
            }
        }

        public LiveRoomInfoStatPreferences(Context context, String str) {
            super(str);
        }

        public /* synthetic */ LiveRoomInfoStatPreferences(Context context, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$Companion;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0002\u0018\u0000B\u0007¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$DisplayPart;", "", "slidInTs", "J", "getSlidInTs", "()J", "setSlidInTs", "(J)V", "slidOutTs", "getSlidOutTs", "setSlidOutTs", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DisplayPart {
        public long slidInTs;
        public long slidOutTs;

        public final long getSlidInTs() {
            return this.slidInTs;
        }

        public final long getSlidOutTs() {
            return this.slidOutTs;
        }

        public final void setSlidInTs(long j) {
            this.slidInTs = j;
        }

        public final void setSlidOutTs(long j) {
            this.slidOutTs = j;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u0000B\u0007¢\u0006\u0004\b \u0010!J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$LiveItemModelWrapper;", "", "calculateDisplayTs", "()J", "Lorg/json/JSONObject;", "getUploadId", "()Lorg/json/JSONObject;", "", "Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin$DisplayPart;", "displayParts", "Ljava/util/List;", "getDisplayParts", "()Ljava/util/List;", "setDisplayParts", "(Ljava/util/List;)V", "", "hasShow", "Z", "getHasShow", "()Z", "setHasShow", "(Z)V", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "liveItemModel", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "getLiveItemModel", "()Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "setLiveItemModel", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "slidReported", "getSlidReported", "setSlidReported", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class LiveItemModelWrapper {
        public List<DisplayPart> displayParts = new ArrayList();
        public boolean hasShow;
        public LiveContainer.LiveItemModel liveItemModel;
        public boolean slidReported;

        public final List<DisplayPart> getDisplayParts() {
            return this.displayParts;
        }

        public final boolean getHasShow() {
            return this.hasShow;
        }

        public final LiveContainer.LiveItemModel getLiveItemModel() {
            return this.liveItemModel;
        }

        public final boolean getSlidReported() {
            return this.slidReported;
        }

        public final long calculateDisplayTs() {
            long j = 0;
            for (DisplayPart displayPart : this.displayParts) {
                if (displayPart.getSlidOutTs() == 0) {
                    displayPart.setSlidOutTs(System.currentTimeMillis());
                }
                j += (displayPart.getSlidOutTs() - displayPart.getSlidInTs()) / 1000;
            }
            return Math.max(1L, j);
        }

        public final JSONObject getUploadId() {
            long currentTimeMillis;
            String str = null;
            if (!this.hasShow || this.slidReported) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            sb.append("sv_");
            LiveContainer.LiveItemModel liveItemModel = this.liveItemModel;
            if (liveItemModel != null) {
                str = liveItemModel.getFeedId();
            }
            sb.append(str);
            jSONObject.put("id", sb.toString());
            jSONObject.put("show", 1);
            if (this.displayParts.size() > 0) {
                currentTimeMillis = this.displayParts.get(0).getSlidInTs();
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            jSONObject.put("show_ts", currentTimeMillis / 1000);
            jSONObject.put("show_dur", calculateDisplayTs());
            if (MiniShellRuntime.INSTANCE.isDebug()) {
                Log.d(LiveRoomInfoStatPlugin.TAG, "upload_id = " + jSONObject);
            }
            return jSONObject;
        }

        public final void setDisplayParts(List<DisplayPart> list) {
            this.displayParts = list;
        }

        public final void setHasShow(boolean z) {
            this.hasShow = z;
        }

        public final void setLiveItemModel(LiveContainer.LiveItemModel liveItemModel) {
            this.liveItemModel = liveItemModel;
        }

        public final void setSlidReported(boolean z) {
            this.slidReported = z;
        }
    }

    public LiveRoomInfoStatPlugin(Context context, MiniUniqueId miniUniqueId) {
        this.context = context;
        this.mixUniqueId = miniUniqueId;
    }

    public final void dispatchFirstLiveItemModelAction(LiveContainer.LiveItemModel liveItemModel) {
        LiveItemModelWrapper liveItemModelWrapper = new LiveItemModelWrapper();
        liveItemModelWrapper.setLiveItemModel(liveItemModel);
        this.liveItemModels.put(liveItemModel.getRoomId(), liveItemModelWrapper);
    }

    private final void recoveryUploadIds() {
        String string = LiveRoomInfoStatPreferences.Companion.getInstance().getString("upload_ids", null);
        if (string != null) {
            try {
                this.recoveryUploadIds = new JSONArray(string);
                if (MiniShellRuntime.INSTANCE.isDebug()) {
                    Log.d(TAG, "recoveryUploadIds = " + this.recoveryUploadIds);
                }
            } catch (Exception e) {
                if (MiniShellRuntime.INSTANCE.isDebug()) {
                    e.printStackTrace();
                    Log.e(TAG, Unit.INSTANCE.toString());
                }
            }
        }
    }

    private final void registerService() {
        ServiceLocator.Companion.registerGlobalServices(StatService.class, new StatService() { // from class: com.baidu.searchbox.live.list.plugin.LiveRoomInfoStatPlugin$registerService$1
            @Override // com.baidu.searchbox.live.list.plugin.LiveRoomInfoStatPlugin.StatService
            public JSONArray getUploadIds() {
                HashMap hashMap;
                JSONArray jSONArray;
                SharedPreferences.Editor putString;
                JSONArray jSONArray2 = new JSONArray();
                hashMap = LiveRoomInfoStatPlugin.this.liveItemModels;
                for (Map.Entry entry : SequencesKt___SequencesKt.filter(MapsKt___MapsKt.asSequence(hashMap), new Function1<Map.Entry<? extends String, ? extends LiveRoomInfoStatPlugin.LiveItemModelWrapper>, Boolean>() { // from class: com.baidu.searchbox.live.list.plugin.LiveRoomInfoStatPlugin$registerService$1$getUploadIds$1
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends String, ? extends LiveRoomInfoStatPlugin.LiveItemModelWrapper> entry2) {
                        return Boolean.valueOf(invoke2((Map.Entry<String, LiveRoomInfoStatPlugin.LiveItemModelWrapper>) entry2));
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final boolean invoke2(Map.Entry<String, LiveRoomInfoStatPlugin.LiveItemModelWrapper> entry2) {
                        if (entry2.getValue().getHasShow() && !entry2.getValue().getSlidReported()) {
                            return true;
                        }
                        return false;
                    }
                })) {
                    JSONObject uploadId = ((LiveRoomInfoStatPlugin.LiveItemModelWrapper) entry.getValue()).getUploadId();
                    ((LiveRoomInfoStatPlugin.LiveItemModelWrapper) entry.getValue()).setSlidReported(true);
                    jSONArray2.put(uploadId);
                }
                jSONArray = LiveRoomInfoStatPlugin.this.recoveryUploadIds;
                if (jSONArray != null) {
                    if (jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            jSONArray2.put(jSONArray.get(i));
                        }
                    }
                    LiveRoomInfoStatPlugin.this.recoveryUploadIds = null;
                    SharedPreferences.Editor edit = LiveRoomInfoStatPlugin.LiveRoomInfoStatPreferences.Companion.getInstance().edit();
                    if (edit != null && (putString = edit.putString("upload_ids", new JSONArray().toString())) != null) {
                        putString.apply();
                    }
                }
                return jSONArray2;
            }
        });
    }

    public final Context getContext() {
        return this.context;
    }

    public final MiniUniqueId getMixUniqueId() {
        return this.mixUniqueId;
    }

    public final void onCreate() {
        recoveryUploadIds();
        registerService();
    }

    public final void onDestroy() {
        saveUploadIds();
    }

    private final void saveUploadIds() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : SequencesKt___SequencesKt.filter(MapsKt___MapsKt.asSequence(this.liveItemModels), new Function1<Map.Entry<? extends String, ? extends LiveItemModelWrapper>, Boolean>() { // from class: com.baidu.searchbox.live.list.plugin.LiveRoomInfoStatPlugin$saveUploadIds$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends String, ? extends LiveRoomInfoStatPlugin.LiveItemModelWrapper> entry2) {
                return Boolean.valueOf(invoke2((Map.Entry<String, LiveRoomInfoStatPlugin.LiveItemModelWrapper>) entry2));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(Map.Entry<String, LiveRoomInfoStatPlugin.LiveItemModelWrapper> entry2) {
                if (entry2.getValue().getHasShow() && !entry2.getValue().getSlidReported()) {
                    return true;
                }
                return false;
            }
        })) {
            jSONArray.put(((LiveItemModelWrapper) entry.getValue()).getUploadId());
        }
        if (jSONArray.length() > 0 && (edit = LiveRoomInfoStatPreferences.Companion.getInstance().edit()) != null && (putString = edit.putString("upload_ids", jSONArray.toString())) != null) {
            putString.apply();
        }
        if (MiniShellRuntime.INSTANCE.isDebug()) {
            Log.d(TAG, "saveUploadIds = " + jSONArray);
        }
    }

    public final void dispatchListResult(String str, int i, List<LiveContainer.LiveItemModel> list) {
        for (LiveContainer.LiveItemModel liveItemModel : list) {
            LiveItemModelWrapper liveItemModelWrapper = new LiveItemModelWrapper();
            liveItemModelWrapper.setLiveItemModel(liveItemModel);
            this.liveItemModels.put(liveItemModel.getRoomId(), liveItemModelWrapper);
        }
    }

    public final void dispatchLiveItemModelSelectedAction(LiveContainer.LiveItemModel liveItemModel) {
        int size;
        String str = this.currentRoomId;
        if (str != null) {
            HashMap<String, LiveItemModelWrapper> hashMap = this.liveItemModels;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            LiveItemModelWrapper liveItemModelWrapper = hashMap.get(str);
            if (liveItemModelWrapper != null && (size = liveItemModelWrapper.getDisplayParts().size()) > 0) {
                liveItemModelWrapper.getDisplayParts().get(size - 1).setSlidOutTs(System.currentTimeMillis());
            }
            this.currentRoomId = null;
            if (MiniShellRuntime.INSTANCE.isDebug()) {
                for (Map.Entry<String, LiveItemModelWrapper> entry : this.liveItemModels.entrySet()) {
                    Log.d(TAG, "roomId = " + entry.getKey() + ", showTs = " + entry.getValue().calculateDisplayTs() + "\n");
                }
            }
        }
        String roomId = liveItemModel.getRoomId();
        this.currentRoomId = roomId;
        if (roomId != null) {
            HashMap<String, LiveItemModelWrapper> hashMap2 = this.liveItemModels;
            if (roomId == null) {
                Intrinsics.throwNpe();
            }
            LiveItemModelWrapper liveItemModelWrapper2 = hashMap2.get(roomId);
            if (liveItemModelWrapper2 != null) {
                DisplayPart displayPart = new DisplayPart();
                displayPart.setSlidInTs(System.currentTimeMillis());
                liveItemModelWrapper2.getDisplayParts().add(displayPart);
                this.currentRoomId = liveItemModel.getRoomId();
                liveItemModelWrapper2.setHasShow(true);
            }
        }
    }
}

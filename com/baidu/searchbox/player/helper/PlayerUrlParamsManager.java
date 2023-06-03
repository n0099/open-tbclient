package com.baidu.searchbox.player.helper;

import com.baidu.searchbox.player.data.SPData;
import com.baidu.searchbox.player.model.VideoSceneEnvModel;
import com.baidu.searchbox.player.model.VideoSceneModel;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.google.zxing.common.StringUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a$\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u000e\u0010$\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0001\u001a\u001a\u0010%\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u001a\u0018\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020\u001bH\u0002\u001a \u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u000f2\u0006\u0010!\u001a\u00020\u0001H\u0002\u001a\u0006\u0010,\u001a\u00020-\u001a\u000e\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0001\u001a\u000e\u00100\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0001\u001a\u001e\u00101\u001a\u000202*\u00020\u00012\b\b\u0002\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0001H\u0002\u001a\u000e\u00106\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010'\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"+\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\"S\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f2\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\"+\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000b\"S\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u000f2\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u000f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014¨\u00067"}, d2 = {"ABTEST", "", "KEY_ABTEST_CONFIG", "KEY_SCENEX_CONFIG", "SCENEX", StringUtils.UTF8, "<set-?>", "abSidConfig", "getAbSidConfig", "()Ljava/lang/String;", "setAbSidConfig", "(Ljava/lang/String;)V", "abSidConfig$delegate", "Lcom/baidu/searchbox/player/data/SPData;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "abSidList", "getAbSidList", "()Ljava/util/ArrayList;", "setAbSidList", "(Ljava/util/ArrayList;)V", "abSidList$delegate", "Lcom/baidu/searchbox/player/helper/NullableLazy;", "sceneConfig", "getSceneConfig", "setSceneConfig", "sceneConfig$delegate", "Lcom/baidu/searchbox/player/model/VideoSceneEnvModel;", "scenexList", "getScenexList", "setScenexList", "scenexList$delegate", "appendUrlParam", "url", "paramKey", "paramValue", "appendVideoAbSidParam", "appendVideoScenexParam", "currentScene", "Lcom/baidu/searchbox/player/model/VideoSceneModel;", "matchScene", "", "configSceneEnv", "parseUrlSidList", "resetVideoUrlConfig", "", "saveVideoAbTestConfig", "config", "saveVideoScenexConfig", "findByRange", "", "startIndex", "", "endString", "mapToSceneValue", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "PlayerUrlParamsManager")
/* loaded from: classes4.dex */
public final class PlayerUrlParamsManager {
    public static final String ABTEST = "abtest";
    public static final String SCENEX = "scenex";
    public static final String UTF8 = "utf-8";
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(PlayerUrlParamsManager.class, "sceneConfig", "getSceneConfig()Ljava/lang/String;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(PlayerUrlParamsManager.class, "abSidConfig", "getAbSidConfig()Ljava/lang/String;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(PlayerUrlParamsManager.class, "scenexList", "getScenexList()Ljava/util/ArrayList;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(PlayerUrlParamsManager.class, "abSidList", "getAbSidList()Ljava/util/ArrayList;", 1))};
    public static final String KEY_SCENEX_CONFIG = "video_scenex_config";
    public static final SPData sceneConfig$delegate = new SPData(KEY_SCENEX_CONFIG, "", null, false, 12, null);
    public static final String KEY_ABTEST_CONFIG = "video_abtest_config";
    public static final SPData abSidConfig$delegate = new SPData(KEY_ABTEST_CONFIG, "", null, false, 12, null);
    public static final NullableLazy scenexList$delegate = new NullableLazy(new Function0<ArrayList<VideoSceneEnvModel>>() { // from class: com.baidu.searchbox.player.helper.PlayerUrlParamsManager$scenexList$2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        public final ArrayList<VideoSceneEnvModel> invoke() {
            String sceneConfig;
            sceneConfig = PlayerUrlParamsManager.getSceneConfig();
            return VideoConfigParser.parseVideoScenexConfig(sceneConfig);
        }
    });
    public static final NullableLazy abSidList$delegate = new NullableLazy(new Function0<ArrayList<String>>() { // from class: com.baidu.searchbox.player.helper.PlayerUrlParamsManager$abSidList$2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        public final ArrayList<String> invoke() {
            String abSidConfig;
            abSidConfig = PlayerUrlParamsManager.getAbSidConfig();
            return VideoConfigParser.parseVideoAbTestConfig(abSidConfig);
        }
    });

    public static final String getAbSidConfig() {
        return (String) abSidConfig$delegate.getValue(null, $$delegatedProperties[1]);
    }

    public static final ArrayList<String> getAbSidList() {
        return (ArrayList) abSidList$delegate.getValue(null, $$delegatedProperties[3]);
    }

    public static final String getSceneConfig() {
        return (String) sceneConfig$delegate.getValue(null, $$delegatedProperties[0]);
    }

    public static final ArrayList<VideoSceneEnvModel> getScenexList() {
        return (ArrayList) scenexList$delegate.getValue(null, $$delegatedProperties[2]);
    }

    public static final void resetVideoUrlConfig() {
        setScenexList(null);
        setAbSidList(null);
    }

    public static final String appendUrlParam(String str, String str2, String str3) {
        boolean z;
        boolean z2;
        String sb;
        if (str2 != null && str2.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (str3 != null && str3.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                try {
                    int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
                    String encode = URLEncoder.encode(str2, "utf-8");
                    String encode2 = URLEncoder.encode(str3, "utf-8");
                    if (indexOf$default > 0) {
                        int[] findByRange = findByRange(str, indexOf$default + encode.length() + 1, "&");
                        sb = new StringBuilder(str).replace(findByRange[0], findByRange[1], encode2).toString();
                    } else {
                        StringBuilder sb2 = new StringBuilder(str);
                        if (!StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "?", false, 2, (Object) null)) {
                            sb2.append("?");
                        } else {
                            sb2.append("&");
                        }
                        sb2.append(encode);
                        sb2.append("=");
                        sb2.append(encode2);
                        sb = sb2.toString();
                    }
                    Intrinsics.checkNotNullExpressionValue(sb, "{\n        val index = ur…oString()\n        }\n    }");
                    return sb;
                } catch (Exception e) {
                    BdVideoLog.e(e.getMessage());
                    return str;
                }
            }
            return str;
        }
        return str;
    }

    public static final String appendVideoAbSidParam(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        ArrayList<String> abSidList = getAbSidList();
        if (abSidList != null) {
            ArrayList<String> parseUrlSidList = parseUrlSidList(url);
            boolean z = false;
            Iterator<String> it = abSidList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!parseUrlSidList.contains(next)) {
                    parseUrlSidList.add(next);
                    z = true;
                }
            }
            if (!z) {
                return url;
            }
            return appendUrlParam(url, "abtest", CollectionsKt___CollectionsKt.joinToString$default(parseUrlSidList, "-", null, null, 0, null, null, 62, null));
        }
        return url;
    }

    public static final String appendVideoScenexParam(String url, VideoSceneModel videoSceneModel) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (videoSceneModel == null) {
            return url;
        }
        ArrayList<VideoSceneEnvModel> scenexList = getScenexList();
        if (scenexList != null) {
            Iterator<VideoSceneEnvModel> it = scenexList.iterator();
            while (it.hasNext()) {
                VideoSceneEnvModel sceneEnvModel = it.next();
                Intrinsics.checkNotNullExpressionValue(sceneEnvModel, "sceneEnvModel");
                if (matchScene(videoSceneModel, sceneEnvModel)) {
                    return appendUrlParam(url, SCENEX, sceneEnvModel.getScenex());
                }
            }
            return url;
        }
        return url;
    }

    public static /* synthetic */ String appendVideoScenexParam$default(String str, VideoSceneModel videoSceneModel, int i, Object obj) {
        if ((i & 2) != 0) {
            videoSceneModel = null;
        }
        return appendVideoScenexParam(str, videoSceneModel);
    }

    public static final int[] findByRange(String str, int i, String str2) {
        int length;
        String substring = str.substring(i);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) substring, str2, 0, false, 6, (Object) null);
        if (indexOf$default >= 0) {
            length = indexOf$default + i;
        } else {
            length = str.length();
        }
        return new int[]{i, length};
    }

    public static /* synthetic */ int[] findByRange$default(String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return findByRange(str, i, str2);
    }

    public static final String mapToSceneValue(VideoSceneModel videoSceneModel) {
        ArrayList<VideoSceneEnvModel> scenexList;
        if (videoSceneModel != null && (scenexList = getScenexList()) != null) {
            for (VideoSceneEnvModel videoSceneEnvModel : scenexList) {
                if (matchScene(videoSceneModel, videoSceneEnvModel)) {
                    return videoSceneEnvModel.getScenex();
                }
            }
        }
        return null;
    }

    public static final void saveVideoAbTestConfig(String config) {
        Intrinsics.checkNotNullParameter(config, "config");
        setAbSidConfig(config);
    }

    public static final void saveVideoScenexConfig(String config) {
        Intrinsics.checkNotNullParameter(config, "config");
        setSceneConfig(config);
    }

    public static final void setAbSidConfig(String str) {
        abSidConfig$delegate.setValue(null, $$delegatedProperties[1], str);
    }

    public static final void setAbSidList(ArrayList<String> arrayList) {
        abSidList$delegate.setValue(null, $$delegatedProperties[3], arrayList);
    }

    public static final void setSceneConfig(String str) {
        sceneConfig$delegate.setValue(null, $$delegatedProperties[0], str);
    }

    public static final void setScenexList(ArrayList<VideoSceneEnvModel> arrayList) {
        scenexList$delegate.setValue(null, $$delegatedProperties[2], arrayList);
    }

    public static final boolean matchScene(VideoSceneModel videoSceneModel, VideoSceneEnvModel videoSceneEnvModel) {
        boolean z;
        boolean z2;
        boolean z3;
        VideoSceneModel sceneModel = videoSceneEnvModel.getSceneModel();
        String from = sceneModel.getFrom();
        if (from != null && from.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z && !Intrinsics.areEqual(sceneModel.getFrom(), videoSceneModel.getFrom())) {
            return false;
        }
        String page = sceneModel.getPage();
        if (page != null && page.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 && !Intrinsics.areEqual(sceneModel.getPage(), videoSceneModel.getPage())) {
            return false;
        }
        String source = sceneModel.getSource();
        if (source != null && source.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3 && !Intrinsics.areEqual(sceneModel.getSource(), videoSceneModel.getSource())) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.ArrayList<java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ArrayList<String> parseUrlSidList(String str) {
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "abtest", 0, false, 6, (Object) null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (indexOf$default > 0) {
            int[] findByRange = findByRange(str, indexOf$default + 6 + 1, "&");
            String substring = str.substring(findByRange[0], findByRange[1]);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            List split$default = StringsKt__StringsKt.split$default((CharSequence) substring, new String[]{"-"}, false, 0, 6, (Object) null);
            int size = split$default.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(split$default.get(i));
            }
        }
        return arrayList;
    }
}

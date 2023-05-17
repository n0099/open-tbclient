package com.baidu.searchbox.common.security;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.List;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\u001a \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0000\u001a\u001c\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0011H\u0000\u001a$\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0000\u001a&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001aH\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001b"}, d2 = {"SyncJsonKeyMap", "Landroid/util/SparseArray;", "", "getSyncJsonKeyMap", "()Landroid/util/SparseArray;", "copyFixedInfo", "", "src", "Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "dst", "Lcom/baidu/searchbox/common/security/CacheDeviceInfo;", "deviceFlag", "", "crcSign", "source", "forEachDevice", "iteratorFun", "Lkotlin/Function1;", "isDeviceInfoSyncMapping", "", "cacheDeviceInfo", "newDeviceValue", "toJson", "Lorg/json/JSONObject;", "infoMap", "validInfoList", "", "lib-security-framework_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeviceInfoUtilKt {
    public static final SparseArray<String> SyncJsonKeyMap;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.put(1, "g");
        sparseArray.put(2, "h");
        sparseArray.put(4, "c");
        sparseArray.put(8, "d");
        sparseArray.put(16, "a");
        sparseArray.put(32, "b");
        sparseArray.put(64, "i");
        sparseArray.put(128, "k");
        sparseArray.put(256, "l");
        SyncJsonKeyMap = sparseArray;
    }

    public static final void copyFixedInfo(final DeviceIdBagMap src, final CacheDeviceInfo dst, final int i) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        forEachDevice(new Function1<Integer, Unit>() { // from class: com.baidu.searchbox.common.security.DeviceInfoUtilKt$copyFixedInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                String str;
                if ((i & i2) != 0) {
                    CacheDeviceInfo cacheDeviceInfo = dst;
                    DeviceIdBag deviceIdBag = (DeviceIdBag) src.get((Object) Integer.valueOf(i2));
                    if (deviceIdBag != null) {
                        str = deviceIdBag.deviceId;
                    } else {
                        str = null;
                    }
                    cacheDeviceInfo.setDeviceInfo(str, i2);
                }
            }
        });
    }

    public static final boolean isDeviceInfoSyncMapping(CacheDeviceInfo cacheDeviceInfo, int i, String str) {
        if (cacheDeviceInfo != null && !TextUtils.isEmpty(str)) {
            return cacheDeviceInfo.isDeviceInfoSyncMapping(i, str);
        }
        return false;
    }

    public static final JSONObject toJson(final DeviceIdBagMap infoMap, final int i, final List<Integer> validInfoList) {
        Intrinsics.checkNotNullParameter(infoMap, "infoMap");
        Intrinsics.checkNotNullParameter(validInfoList, "validInfoList");
        final JSONObject jSONObject = new JSONObject();
        forEachDevice(new Function1<Integer, Unit>() { // from class: com.baidu.searchbox.common.security.DeviceInfoUtilKt$toJson$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                DeviceIdBag deviceIdBag;
                if ((i & i2) != 0 && (deviceIdBag = (DeviceIdBag) infoMap.get((Object) Integer.valueOf(i2))) != null && !TextUtils.isEmpty(deviceIdBag.deviceId)) {
                    validInfoList.add(Integer.valueOf(i2));
                    String str = DeviceInfoUtilKt.getSyncJsonKeyMap().get(i2);
                    if (i2 == 2) {
                        JSONObject jSONObject2 = jSONObject;
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(deviceIdBag.deviceId);
                        Unit unit = Unit.INSTANCE;
                        jSONObject2.put(str, jSONArray);
                        return;
                    }
                    jSONObject.put(str, deviceIdBag.deviceId);
                }
            }
        });
        return jSONObject;
    }

    public static final String crcSign(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        CRC32 crc32 = new CRC32();
        byte[] bytes = source.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        crc32.update(bytes);
        return String.valueOf(crc32.getValue());
    }

    public static final void forEachDevice(Function1<? super Integer, Unit> iteratorFun) {
        Intrinsics.checkNotNullParameter(iteratorFun, "iteratorFun");
        for (int i = 0; i < 9; i++) {
            iteratorFun.invoke(Integer.valueOf(1 << i));
        }
    }

    public static final SparseArray<String> getSyncJsonKeyMap() {
        return SyncJsonKeyMap;
    }
}

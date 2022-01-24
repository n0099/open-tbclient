package com.baidu.searchbox.download.center.clearcache;

import android.os.Build;
import android.system.Os;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public final class DiskUtilKt$cleanCacheMonitorUBC$1$baidu$1 extends Lambda implements Function1<File, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ JSONArray $exceptionFiles;
    public final /* synthetic */ JSONObject $extList;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ long $total;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskUtilKt$cleanCacheMonitorUBC$1$baidu$1(JSONArray jSONArray, long j2, JSONObject jSONObject) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray, Long.valueOf(j2), jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$exceptionFiles = jSONArray;
        this.$total = j2;
        this.$extList = jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(File file) {
        invoke2(file);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(File it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (this.$exceptionFiles.length() < 10 && it.length() >= this.$total) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("path", it.getAbsolutePath());
                jSONObject.put("length", it.length());
                jSONObject.put("lastModified", it.lastModified());
                jSONObject.put("lastAccessTime", Build.VERSION.SDK_INT >= 21 ? Os.lstat(it.getAbsolutePath()).st_atime : 0L);
                this.$exceptionFiles.put(jSONObject);
            }
            String filePath = it.getAbsolutePath();
            for (Map.Entry<String, String> entry : DiskUtilKt.getDIR_BUSINESS_MAP().entrySet()) {
                String value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
                if (StringsKt__StringsKt.contains$default((CharSequence) filePath, (CharSequence) entry.getKey(), false, 2, (Object) null)) {
                    JSONObject jSONObject2 = this.$extList;
                    jSONObject2.put(value, jSONObject2.optLong(value) + it.length());
                    return;
                }
            }
        }
    }
}

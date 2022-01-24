package com.baidu.searchbox.fluency.tracer;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.Logcat;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "com.baidu.searchbox.fluency.tracer.FpsTracer$FrameCollectItem$saveCsv$2", f = "FpsTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class FpsTracer$FrameCollectItem$saveCsv$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ FpsTracer.FrameCollectItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FpsTracer$FrameCollectItem$saveCsv$2(FpsTracer.FrameCollectItem frameCollectItem, Continuation continuation) {
        super(2, continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameCollectItem, continuation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (Continuation) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = frameCollectItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, completion)) == null) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            FpsTracer$FrameCollectItem$saveCsv$2 fpsTracer$FrameCollectItem$saveCsv$2 = new FpsTracer$FrameCollectItem$saveCsv$2(this.this$0, completion);
            fpsTracer$FrameCollectItem$saveCsv$2.p$ = (CoroutineScope) obj;
            return fpsTracer$FrameCollectItem$saveCsv$2;
        }
        return (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coroutineScope, continuation)) == null) ? ((FpsTracer$FrameCollectItem$saveCsv$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r15v10 int), (',' char), (r1v10 int), (',' char), (r2v12 int), (',' char), (r3v9 int), (',' char), (r4v4 int), (',' char), (r5v4 int)] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        String str;
        int i2;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        File csvFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    str = this.this$0.from;
                } catch (Exception e2) {
                    Logcat logcat = Logcat.INSTANCE;
                    logcat.e(FpsTracer.TAG, "saveCsv, exception: " + e2);
                }
                if (TextUtils.equals(str, ExternalTransferSpeedStats.FEED_PAGE)) {
                    i2 = this.this$0.sumFrames;
                    int roundToInt = MathKt__MathJVMKt.roundToInt(Math.min(60.0f, (i2 * 1000.0f) / this.this$0.getSumFrameCost()));
                    Logcat logcat2 = Logcat.INSTANCE;
                    logcat2.d(FpsTracer.TAG, "[saveCsv] fps: " + roundToInt + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.this$0.toString());
                    iArr = this.this$0.dropLevel;
                    int i3 = iArr[DropLevel.DROPPED_FROZEN.getIndex()];
                    iArr2 = this.this$0.dropLevel;
                    int i4 = iArr2[DropLevel.DROPPED_HIGH.getIndex()];
                    iArr3 = this.this$0.dropLevel;
                    int i5 = iArr3[DropLevel.DROPPED_MIDDLE.getIndex()];
                    iArr4 = this.this$0.dropLevel;
                    int i6 = iArr4[DropLevel.DROPPED_NORMAL.getIndex()];
                    iArr5 = this.this$0.dropLevel;
                    int i7 = iArr5[DropLevel.DROPPED_BEST.getIndex()];
                    csvFile = this.this$0.this$0.getCsvFile();
                    if (!csvFile.exists()) {
                        Logcat logcat3 = Logcat.INSTANCE;
                        logcat3.d(FpsTracer.TAG, "create file: " + csvFile.getAbsolutePath());
                        FileOutputStream fileOutputStream = new FileOutputStream(csvFile);
                        byte[] bytes = "fps,dropFrozen,dropHigh,dropMiddle,dropNormal,dropBest".getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                        fileOutputStream.write(bytes);
                        byte[] bytes2 = "\r\n".getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                        fileOutputStream.write(bytes2);
                        StringBuilder sb = new StringBuilder();
                        sb.append(roundToInt);
                        sb.append(',');
                        sb.append(i3);
                        sb.append(',');
                        sb.append(i4);
                        sb.append(',');
                        sb.append(i5);
                        sb.append(',');
                        sb.append(i6);
                        sb.append(',');
                        sb.append(i7);
                        String sb2 = sb.toString();
                        Charset charset = Charsets.UTF_8;
                        if (sb2 != null) {
                            byte[] bytes3 = sb2.getBytes(charset);
                            Intrinsics.checkNotNullExpressionValue(bytes3, "(this as java.lang.String).getBytes(charset)");
                            fileOutputStream.write(bytes3);
                            fileOutputStream.close();
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        Logcat logcat4 = Logcat.INSTANCE;
                        logcat4.d(FpsTracer.TAG, "file exist: " + csvFile.getAbsolutePath());
                        FileOutputStream fileOutputStream2 = new FileOutputStream(csvFile, true);
                        byte[] bytes4 = "\r\n".getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes4, "(this as java.lang.String).getBytes(charset)");
                        fileOutputStream2.write(bytes4);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(roundToInt);
                        sb3.append(',');
                        sb3.append(i3);
                        sb3.append(',');
                        sb3.append(i4);
                        sb3.append(',');
                        sb3.append(i5);
                        sb3.append(',');
                        sb3.append(i6);
                        sb3.append(',');
                        sb3.append(i7);
                        String sb4 = sb3.toString();
                        Charset charset2 = Charsets.UTF_8;
                        if (sb4 != null) {
                            byte[] bytes5 = sb4.getBytes(charset2);
                            Intrinsics.checkNotNullExpressionValue(bytes5, "(this as java.lang.String).getBytes(charset)");
                            fileOutputStream2.write(bytes5);
                            fileOutputStream2.close();
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return invokeL.objValue;
    }
}

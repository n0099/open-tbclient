package com.baidu.bdtask.ui.components.buoy;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.framework.ui.buoy.BuoyViewData;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.bdtask.ui.utils.d;
import com.baidu.tieba.R;
import com.baidu.tieba.av;
import com.baidu.tieba.bv;
import com.baidu.tieba.cr;
import com.baidu.tieba.et;
import com.baidu.tieba.fs;
import com.baidu.tieba.fu;
import com.baidu.tieba.gu;
import com.baidu.tieba.lp;
import com.baidu.tieba.lv;
import com.baidu.tieba.mv;
import com.baidu.tieba.zu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u000fJ\u000f\u0010 \u001a\u00020\u0003H\u0016¢\u0006\u0004\b \u0010\u000fJ\u000f\u0010!\u001a\u00020\u0018H\u0002¢\u0006\u0004\b!\u0010\"J!\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020,2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020,2\u0006\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020,H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020,H\u0016¢\u0006\u0004\b6\u00105J\u000f\u00107\u001a\u00020,H\u0002¢\u0006\u0004\b7\u00105J\u000f\u00108\u001a\u00020\u0005H\u0016¢\u0006\u0004\b8\u0010)J\u000f\u00109\u001a\u00020\u0005H\u0016¢\u0006\u0004\b9\u0010)J\u0017\u0010<\u001a\u00020\u00052\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b<\u0010=J\u001f\u0010>\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002¢\u0006\u0004\b>\u0010?J'\u0010A\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00132\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0013H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0013H\u0002¢\u0006\u0004\bF\u0010EJ\u0017\u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0013H\u0002¢\u0006\u0004\bH\u0010EJ\u001f\u0010K\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u00132\u0006\u0010J\u001a\u00020\u0013H\u0002¢\u0006\u0004\bK\u0010LJ'\u0010O\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010N\u001a\u00020\u0013H\u0002¢\u0006\u0004\bO\u0010PJ!\u0010R\u001a\u00020\u00052\u0010\b\u0002\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0002¢\u0006\u0004\bR\u0010SR\u0016\u0010T\u001a\u00020\u00038\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u00038\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bV\u0010UR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010[\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010^\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010`\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010UR\"\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR(\u0010g\u001a\u00020f8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bg\u0010h\u0012\u0004\bm\u0010)\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR*\u0010o\u001a\u0004\u0018\u00010n8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bo\u0010p\u0012\u0004\bu\u0010)\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010vR\u0016\u0010w\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010y\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010{\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010aR\u0016\u0010|\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010aR\u0016\u00104\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010aR\u0016\u0010}\u001a\u00020,8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b}\u0010aR\u0019\u0010\u007f\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001b\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0082\u0001R\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0082\u0001R\u001b\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0082\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001e\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020%0c8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010eR\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001b\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001¨\u0006\u0094\u0001"}, d2 = {"Lcom/baidu/bdtask/ui/components/buoy/TaskBuoyView;", "Lcom/baidu/tieba/zu;", "Lcom/baidu/tieba/lp;", "", "newStatus", "", "addStatus", "(I)V", "Lcom/baidu/bdtask/framework/ui/buoy/BuoyViewData;", "data", "Lkotlin/Function0;", "nextAction", "buoyViewInit", "(Lcom/baidu/bdtask/framework/ui/buoy/BuoyViewData;Lkotlin/Function0;)V", "getAnimationProcessBufferTime", "()I", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "", "actionId", "Lcom/baidu/bdtask/model/info/TaskInfo;", "getCurTaskInfo", "(Ljava/lang/String;)Lcom/baidu/bdtask/model/info/TaskInfo;", "", "rate", "msg", "", "total", "getFormatMsgStr", "(FLjava/lang/String;J)Ljava/lang/String;", "getLayoutId", "getMaxProcessValue", "getRate", "()F", "start", "end", "Ljava/lang/Runnable;", "getUpdateAction", "(II)Ljava/lang/Runnable;", "initView", "()V", "Landroid/content/Context;", "context", "", "isActivityValid", "(Landroid/content/Context;)Z", "isFirstRoundTask", "(Ljava/lang/String;)Z", "checkStatus", "isIncluded", "(I)Z", "isReady", "()Z", "isSmooth", "isUpdateEnable", "onAttachedToWindow", "onDetachedFromWindow", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModel;", "model", "onViewModelBind", "(Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModel;)V", "requestUpdateProcess", "(II)V", TaskUIData.keyBgUrl, "updateBg", "(Ljava/lang/String;Lkotlin/Function0;)V", "closeBgUrl", "updateCloseBg", "(Ljava/lang/String;)V", "updateMsg", TaskUIData.keyTxtColor, "updateMsgUI", "pBackColor", "pForeColor", "updateProcessUI", "(Ljava/lang/String;Ljava/lang/String;)V", "totalTime", "message", "updateProcessValue", "(FJLjava/lang/String;)V", "action", "withSafeRun", "(Lkotlin/Function0;)V", "DEFAULT_BUFFER_TIME", "I", "MAX_PROCESS_VALUE", "Ljava/util/concurrent/locks/ReentrantLock;", "actionLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroid/widget/ImageView;", "buoyClose", "Landroid/widget/ImageView;", "Landroid/widget/RelativeLayout;", "buoyContainer", "Landroid/widget/RelativeLayout;", "buoyHide", "Z", "buoyStatus", "Ljava/util/Queue;", "cacheActions", "Ljava/util/Queue;", "Lcom/baidu/bdtask/ui/components/buoy/TaskBuoyViewClickListener;", "componentClickListener", "Lcom/baidu/bdtask/ui/components/buoy/TaskBuoyViewClickListener;", "getComponentClickListener", "()Lcom/baidu/bdtask/ui/components/buoy/TaskBuoyViewClickListener;", "setComponentClickListener", "(Lcom/baidu/bdtask/ui/components/buoy/TaskBuoyViewClickListener;)V", "componentClickListener$annotations", "Landroid/view/View$OnClickListener;", "componentCloseExtraClickListener", "Landroid/view/View$OnClickListener;", "getComponentCloseExtraClickListener", "()Landroid/view/View$OnClickListener;", "setComponentCloseExtraClickListener", "(Landroid/view/View$OnClickListener;)V", "componentCloseExtraClickListener$annotations", "Landroid/content/Context;", "curRate", "F", "curTaskModel", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModel;", "isAttached", "isDetached", "isUpdating", "Landroid/widget/TextView;", "msgTextView", "Landroid/widget/TextView;", "preBgUrl", "Ljava/lang/String;", "preCloseBgUrl", "preProcessBackColor", "preProcessForeColor", "Landroid/widget/ProgressBar;", "progressBar", "Landroid/widget/ProgressBar;", "Lcom/baidu/bdtask/ui/components/buoy/BuoyContainer;", "root", "Lcom/baidu/bdtask/ui/components/buoy/BuoyContainer;", "updateQueue", "Landroid/animation/ValueAnimator;", "valueAnimator", "Landroid/animation/ValueAnimator;", "view", "Landroid/view/View;", "<init>", "(Landroid/content/Context;)V", "lib-bdtask-ui-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public class TaskBuoyView extends lp implements zu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TaskBuoyViewModel A;
    public final Context B;
    public final BuoyContainer c;
    public View d;
    public RelativeLayout e;
    public ImageView f;
    public final TextView g;
    public ProgressBar h;
    public bv i;
    public View.OnClickListener j;
    public final Queue<Runnable> k;
    public final int l;
    public final int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public String s;
    public String t;
    public boolean u;
    public volatile boolean v;
    public ValueAnimator w;
    public Queue<Function0<Unit>> x;
    public final ReentrantLock y;
    public int z;

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.layout.sdk_task_buoy_view : invokeV.intValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TaskBuoyView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public a(TaskBuoyView taskBuoyView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskBuoyView, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = taskBuoyView;
            this.b = i;
            this.c = i2;
        }

        /* renamed from: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0081a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0081a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    Intrinsics.checkExpressionValueIsNotNull(animation, "animation");
                    Object animatedValue = animation.getAnimatedValue();
                    if (animatedValue != null) {
                        int intValue = ((Integer) animatedValue).intValue();
                        if (!this.a.a.S()) {
                            animation.cancel();
                            return;
                        }
                        ProgressBar progressBar = this.a.a.h;
                        if (progressBar != null) {
                            progressBar.setProgress(intValue);
                            return;
                        }
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
            }
        }

        /* loaded from: classes3.dex */
        public static final class b implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                }
            }

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                    return;
                }
                this.a.a.v = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                    return;
                }
                this.a.a.v = false;
                this.a.a.T(-1, -1);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            ValueAnimator valueAnimator;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.v = true;
            if (this.a.w != null && (valueAnimator = this.a.w) != null) {
                valueAnimator.cancel();
            }
            this.a.w = ValueAnimator.ofInt(this.b, this.c);
            ValueAnimator valueAnimator2 = this.a.w;
            if (valueAnimator2 != null) {
                valueAnimator2.setInterpolator(new LinearInterpolator());
            }
            ValueAnimator valueAnimator3 = this.a.w;
            if (valueAnimator3 != null) {
                valueAnimator3.addUpdateListener(new C0081a(this));
            }
            ValueAnimator valueAnimator4 = this.a.w;
            if (valueAnimator4 != null) {
                valueAnimator4.addListener(new b(this));
            }
            ValueAnimator valueAnimator5 = this.a.w;
            if (valueAnimator5 != null) {
                valueAnimator5.setDuration(this.a.G());
            }
            ValueAnimator valueAnimator6 = this.a.w;
            if (valueAnimator6 != null) {
                valueAnimator6.start();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TaskBuoyView a;

        public b(TaskBuoyView taskBuoyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskBuoyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = taskBuoyView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            TaskInfo c;
            fu v;
            gu d;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.u = true;
            if (this.a.S()) {
                this.a.getContentView().setVisibility(4);
            }
            TaskBuoyViewModel taskBuoyViewModel = this.a.A;
            if (taskBuoyViewModel != null && (c = taskBuoyViewModel.c()) != null && (v = BDPTask.m.v()) != null && (d = v.d()) != null) {
                d.b(c.getSingleKey(), cr.c.a());
            }
            this.a.c().a();
            View.OnClickListener I = this.a.I();
            if (I != null) {
                I.onClick(this.a.f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TaskBuoyView a;

        public c(TaskBuoyView taskBuoyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskBuoyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = taskBuoyView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.A == null) {
                return;
            }
            TaskBuoyViewModel taskBuoyViewModel = this.a.A;
            if (taskBuoyViewModel == null) {
                Intrinsics.throwNpe();
            }
            TaskInfo c = taskBuoyViewModel.c();
            TaskBuoyViewModel taskBuoyViewModel2 = this.a.A;
            if (taskBuoyViewModel2 == null) {
                Intrinsics.throwNpe();
            }
            TaskBuoyViewData viewData = taskBuoyViewModel2.a().k();
            if (viewData != null && viewData.getTaskStatus().isFinished()) {
                this.a.c().b();
                bv H = this.a.H();
                BuoyContainer buoyContainer = this.a.c;
                Intrinsics.checkExpressionValueIsNotNull(viewData, "viewData");
                H.a(buoyContainer, c, viewData);
            }
        }
    }

    public TaskBuoyView(Context context) {
        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = context;
        Context applicationContext = this.B.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "context.applicationContext");
        this.c = new BuoyContainer(applicationContext, this);
        View inflate = LayoutInflater.from(this.B.getApplicationContext()).inflate(K(), this.c);
        this.d = inflate;
        if (inflate != null) {
            relativeLayout = (RelativeLayout) inflate.findViewById(R.id.buoy_container);
        } else {
            relativeLayout = null;
        }
        this.e = relativeLayout;
        View view2 = this.d;
        if (view2 != null) {
            imageView = (ImageView) view2.findViewById(R.id.buoy_close);
        } else {
            imageView = null;
        }
        this.f = imageView;
        View view3 = this.d;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.task_buoy_message);
        } else {
            textView = null;
        }
        this.g = textView;
        View view4 = this.d;
        this.h = view4 != null ? (ProgressBar) view4.findViewById(R.id.task_tip_process) : null;
        this.i = new av();
        this.k = new ConcurrentLinkedQueue();
        this.l = 1000;
        this.m = 500;
        this.x = new LinkedList();
        this.y = new ReentrantLock();
        N();
    }

    public final Runnable M(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) {
            if (i != -1 && i2 != -1) {
                return new a(this, i, i2);
            }
            return null;
        }
        return (Runnable) invokeII.objValue;
    }

    public final void V(final String str, final Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, function0) == null) {
            if (!Intrinsics.areEqual(this.q, str) && !TextUtils.isEmpty(str)) {
                d.a.b(str, this.e, new Function0<Unit>(this, str, function0) { // from class: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$updateBg$2
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ String $bgUrl;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Function0 $nextAction;
                    public final /* synthetic */ TaskBuoyView this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, function0};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.$bgUrl = str;
                        this.$nextAction = function0;
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.this$0.q = this.$bgUrl;
                            this.$nextAction.invoke();
                        }
                    }
                }, function0);
            } else {
                function0.invoke();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.bdtask.ui.components.buoy.TaskBuoyView */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d0(TaskBuoyView taskBuoyView, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function0 = null;
            }
            taskBuoyView.c0(function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withSafeRun");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.bdtask.ui.components.buoy.TaskBuoyView */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void W(TaskBuoyView taskBuoyView, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = TaskBuoyView$updateBg$1.INSTANCE;
            }
            taskBuoyView.V(str, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateBg");
    }

    public final void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.z = i | this.z;
        }
    }

    public boolean O(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            if (!(context instanceof Activity)) {
                return true;
            }
            return !et.a((Activity) context);
        }
        return invokeL.booleanValue;
    }

    public final boolean P(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if ((this.z & i) == i) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void U(bv bvVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bvVar) == null) {
            this.i = bvVar;
        }
    }

    public final void X(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && !Intrinsics.areEqual(this.r, str) && !TextUtils.isEmpty(str)) {
            d.a.a(str, this.f);
            this.r = str;
        }
    }

    public final void Y(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && (textView = this.g) != null) {
            textView.setText(str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vs
    /* renamed from: d */
    public void a(TaskBuoyViewModel taskBuoyViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, taskBuoyViewModel) == null) {
            super.d(taskBuoyViewModel);
            this.A = taskBuoyViewModel;
            taskBuoyViewModel.a().l(new TaskBuoyView$onViewModelBind$1(this));
        }
    }

    public final void F(BuoyViewData buoyViewData, final Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buoyViewData, function0) == null) {
            a0(buoyViewData.getPBackColor(), buoyViewData.getPForeColor());
            Z(buoyViewData.getTxtColor());
            X(buoyViewData.getCloseBg());
            V(buoyViewData.getBgUrl(), new Function0<Unit>(function0) { // from class: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$buoyViewInit$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function0 $nextAction;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function0};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$nextAction = function0;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.$nextAction.invoke();
                    }
                }
            });
        }
    }

    public final void T(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            Runnable M = M(i, i2);
            if (!this.v) {
                while (!this.k.isEmpty()) {
                    Runnable poll = this.k.poll();
                    if (poll != null) {
                        poll.run();
                    }
                }
                if (M != null) {
                    M.run();
                }
            } else if (M != null) {
                this.k.add(M);
            }
        }
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public final bv H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return (bv) invokeV.objValue;
    }

    public final View.OnClickListener I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.o && this.n) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rs
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zu
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.o = true;
            this.p = false;
            DebugTrace.a.c(TaskBuoyView$onAttachedToWindow$1.INSTANCE);
            d0(this, null, 1, null);
        }
    }

    @Override // com.baidu.tieba.zu
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.p = true;
            DebugTrace.a.c(TaskBuoyView$onDetachedFromWindow$1.INSTANCE);
            d0(this, null, 1, null);
        }
    }

    public final String J(float f, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), str, Long.valueOf(j)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((int) Math.ceil(((float) j) * (1 - f)), 0);
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, "!(complete)", String.valueOf(RangesKt___RangesKt.coerceAtLeast(j - coerceAtLeast, 0L)), false, 4, (Object) null), "!(total)", String.valueOf((int) j), false, 4, (Object) null), "!(left)", String.valueOf(coerceAtLeast), false, 4, (Object) null);
        }
        return (String) invokeCommon.objValue;
    }

    public final void b0(float f, long j, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f), Long.valueOf(j), str}) == null) {
            int L = (int) (L() * f);
            if (R()) {
                ProgressBar progressBar = this.h;
                if (progressBar != null) {
                    i = progressBar.getProgress();
                } else {
                    i = 0;
                }
                if (i < L) {
                    if (this.v) {
                        ValueAnimator valueAnimator = this.w;
                        if (valueAnimator != null) {
                            valueAnimator.cancel();
                        }
                        this.k.clear();
                    }
                    Y(J(f, str, j));
                    ProgressBar progressBar2 = this.h;
                    if (progressBar2 != null) {
                        T(progressBar2.getProgress(), L);
                        return;
                    }
                    return;
                }
            }
            ProgressBar progressBar3 = this.h;
            if (progressBar3 != null) {
                progressBar3.setProgress(L);
            }
            Y(J(f, str, j));
        }
    }

    public final void N() {
        fs h;
        Context appContext;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ProgressBar progressBar = this.h;
            if (progressBar != null) {
                progressBar.setMax(L());
            }
            ProgressBar progressBar2 = this.h;
            if (progressBar2 != null) {
                progressBar2.setProgress(0);
            }
            ImageView imageView = this.f;
            if (imageView != null) {
                imageView.setOnClickListener(new b(this));
            }
            View view2 = this.d;
            if (view2 != null) {
                view2.setOnClickListener(new c(this));
            }
            View view3 = this.d;
            if (view3 != null) {
                view3.setClickable(true);
            }
            fu v = BDPTask.m.v();
            if (v != null && (h = v.h()) != null && (appContext = h.getAppContext()) != null && (resources = appContext.getResources()) != null) {
                mv.a(this.d, this.f, resources.getDimensionPixelSize(R.dimen.sdk_buoy_close_expend_size));
                getContentView().setVisibility(4);
            }
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!O(this.B)) {
                return false;
            }
            View view2 = this.d;
            if (view2 != null) {
                viewParent = view2.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent == null || !Q() || this.p) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Z(String str) {
        fu v;
        fs h;
        Context appContext;
        Resources resources;
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (v = BDPTask.m.v()) != null && (h = v.h()) != null && (appContext = h.getAppContext()) != null && (resources = appContext.getResources()) != null && (textView = this.g) != null) {
            textView.setTextColor(lv.a.a(str, resources.getColor(R.color.task_sdk_text_color_default)));
        }
    }

    public final void a0(String str, String str2) {
        fu v;
        fs h;
        Context appContext;
        Resources resources;
        Drawable drawable;
        Drawable progressDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048598, this, str, str2) != null) || this.h == null) {
            return;
        }
        if ((!TextUtils.equals(str, this.t) || !TextUtils.equals(str2, this.s)) && (v = BDPTask.m.v()) != null && (h = v.h()) != null && (appContext = h.getAppContext()) != null && (resources = appContext.getResources()) != null) {
            ProgressBar progressBar = this.h;
            if (progressBar != null && (progressDrawable = progressBar.getProgressDrawable()) != null) {
                drawable = progressDrawable.mutate();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawable2 = layerDrawable.getDrawable(0);
                if (drawable2 != null) {
                    ((GradientDrawable) drawable2).setColor(lv.a.a(str, resources.getColor(R.color.task_sdk_process_back_color_default)));
                    Drawable drawable3 = layerDrawable.getDrawable(1);
                    if (drawable3 != null) {
                        Drawable drawable4 = ((ScaleDrawable) drawable3).getDrawable();
                        if (drawable4 != null) {
                            ((GradientDrawable) drawable4).setColor(lv.a.a(str2, resources.getColor(R.color.task_sdk_process_force_color_default)));
                            ProgressBar progressBar2 = this.h;
                            if (progressBar2 != null) {
                                progressBar2.setProgressDrawable(layerDrawable);
                            }
                            this.t = str;
                            this.s = str2;
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.ScaleDrawable");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        }
    }

    public final void c0(Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, function0) == null) {
            ReentrantLock reentrantLock = this.y;
            reentrantLock.lock();
            try {
                if (this.p) {
                    this.x.clear();
                } else if (!S()) {
                    if (function0 != null) {
                        this.x.add(function0);
                    }
                } else {
                    while (!this.x.isEmpty()) {
                        Function0<Unit> poll = this.x.poll();
                        if (poll != null) {
                            poll.invoke();
                        }
                    }
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}

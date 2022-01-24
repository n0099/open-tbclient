package com.baidu.searchbox.fluency.listener;

import androidx.annotation.CallSuper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.listener.FrameRateListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 #:\u0002#$B\u0007¢\u0006\u0004\b!\u0010\"JO\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u000e\u0010\u000fJO\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJO\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u001d\u0010\u0016\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010 ¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/fluency/listener/FrameRateListener;", "", "topPage", "", "startNs", "endNs", "", "dropFrames", "", "isVsyncFrame", "inputCostNs", "animationCostNs", "traversalCostNs", "", "collect", "(Ljava/lang/String;JJIZJJJ)V", "dropFrame", "doFrameAsync", "doFrameSync", "", "Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;", "frameList", "doReplay", "(Ljava/util/List;)V", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "getIntervalFrameReplay", "()I", "executor", "Ljava/util/concurrent/Executor;", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "<init>", "()V", "Companion", "FrameReplay", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public class FrameRateListener {
    public static /* synthetic */ Interceptable $ic;
    public static final Companion Companion;
    public static final LinkedList<FrameReplay> framePool;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor executor;
    public final LinkedList<FrameReplay> frameList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/fluency/listener/FrameRateListener$Companion;", "Ljava/util/LinkedList;", "Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;", "framePool", "Ljava/util/LinkedList;", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes11.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 ,:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u0003J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\b\"\u0004\b*\u0010\n¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;", "", "recycle", "()V", "", "animationCostNs", "J", "getAnimationCostNs", "()J", "setAnimationCostNs", "(J)V", "", "dropFrame", "I", "getDropFrame", "()I", "setDropFrame", "(I)V", "endNs", "getEndNs", "setEndNs", "inputCostNs", "getInputCostNs", "setInputCostNs", "", "isVsyncFrame", "Z", "()Z", "setVsyncFrame", "(Z)V", "startNs", "getStartNs", "setStartNs", "", "topPage", "Ljava/lang/String;", "getTopPage", "()Ljava/lang/String;", "setTopPage", "(Ljava/lang/String;)V", "traversalCostNs", "getTraversalCostNs", "setTraversalCostNs", "<init>", "Companion", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes11.dex */
    public static final class FrameReplay {
        public static /* synthetic */ Interceptable $ic;
        public static final Companion Companion;
        public transient /* synthetic */ FieldHolder $fh;
        public long animationCostNs;
        public int dropFrame;
        public long endNs;
        public long inputCostNs;
        public boolean isVsyncFrame;
        public long startNs;
        public String topPage;
        public long traversalCostNs;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay$Companion;", "Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;", "create", "()Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes11.dex */
        public static final class Companion {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public Companion() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public final FrameReplay create() {
                InterceptResult invokeV;
                FrameReplay frameReplay;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    synchronized (FrameRateListener.framePool) {
                        frameReplay = (FrameReplay) FrameRateListener.framePool.poll();
                        Unit unit = Unit.INSTANCE;
                    }
                    if (frameReplay == null) {
                        return new FrameReplay();
                    }
                    Intrinsics.checkNotNull(frameReplay);
                    return frameReplay;
                }
                return (FrameReplay) invokeV.objValue;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-772653942, "Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-772653942, "Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;");
                    return;
                }
            }
            Companion = new Companion(null);
        }

        public FrameReplay() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.topPage = "";
        }

        public final long getAnimationCostNs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.animationCostNs : invokeV.longValue;
        }

        public final int getDropFrame() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dropFrame : invokeV.intValue;
        }

        public final long getEndNs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.endNs : invokeV.longValue;
        }

        public final long getInputCostNs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.inputCostNs : invokeV.longValue;
        }

        public final long getStartNs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.startNs : invokeV.longValue;
        }

        public final String getTopPage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.topPage : (String) invokeV.objValue;
        }

        public final long getTraversalCostNs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.traversalCostNs : invokeV.longValue;
        }

        public final boolean isVsyncFrame() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.isVsyncFrame : invokeV.booleanValue;
        }

        public final void recycle() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || FrameRateListener.framePool.size() > 1000) {
                return;
            }
            synchronized (FrameRateListener.framePool) {
                this.topPage = "";
                this.startNs = 0L;
                this.endNs = 0L;
                this.dropFrame = 0;
                this.isVsyncFrame = false;
                this.inputCostNs = 0L;
                this.animationCostNs = 0L;
                this.traversalCostNs = 0L;
                FrameRateListener.framePool.add(this);
            }
        }

        public final void setAnimationCostNs(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
                this.animationCostNs = j2;
            }
        }

        public final void setDropFrame(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
                this.dropFrame = i2;
            }
        }

        public final void setEndNs(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
                this.endNs = j2;
            }
        }

        public final void setInputCostNs(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
                this.inputCostNs = j2;
            }
        }

        public final void setStartNs(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
                this.startNs = j2;
            }
        }

        public final void setTopPage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.topPage = str;
            }
        }

        public final void setTraversalCostNs(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
                this.traversalCostNs = j2;
            }
        }

        public final void setVsyncFrame(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
                this.isVsyncFrame = z;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(309659130, "Lcom/baidu/searchbox/fluency/listener/FrameRateListener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(309659130, "Lcom/baidu/searchbox/fluency/listener/FrameRateListener;");
                return;
            }
        }
        Companion = new Companion(null);
        framePool = new LinkedList<>();
    }

    public FrameRateListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.frameList = new LinkedList<>();
    }

    @CallSuper
    public void collect(String topPage, long j2, long j3, int i2, boolean z, long j4, long j5, long j6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{topPage, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) {
            Intrinsics.checkNotNullParameter(topPage, "topPage");
            FrameReplay create = FrameReplay.Companion.create();
            create.setTopPage(topPage);
            create.setStartNs(j2);
            create.setEndNs(j3);
            create.setDropFrame(i2);
            create.setVsyncFrame(z);
            create.setInputCostNs(j4);
            create.setAnimationCostNs(j5);
            create.setTraversalCostNs(j6);
            this.frameList.add(create);
            if (this.frameList.size() >= getIntervalFrameReplay()) {
                final LinkedList linkedList = new LinkedList(this.frameList);
                this.frameList.clear();
                Executor executor = getExecutor();
                Intrinsics.checkNotNull(executor);
                executor.execute(new Runnable(this, linkedList) { // from class: com.baidu.searchbox.fluency.listener.FrameRateListener$collect$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ LinkedList $copy;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FrameRateListener this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, linkedList};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.$copy = linkedList;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.doReplay(this.$copy);
                            Iterator it = this.$copy.iterator();
                            while (it.hasNext()) {
                                ((FrameRateListener.FrameReplay) it.next()).recycle();
                            }
                        }
                    }
                });
            }
        }
    }

    public void doFrameAsync(String topPage, long j2, long j3, int i2, boolean z, long j4, long j5, long j6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{topPage, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) {
            Intrinsics.checkNotNullParameter(topPage, "topPage");
        }
    }

    public void doFrameSync(String topPage, long j2, long j3, int i2, boolean z, long j4, long j5, long j6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{topPage, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) {
            Intrinsics.checkNotNullParameter(topPage, "topPage");
        }
    }

    public void doReplay(List<FrameReplay> frameList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, frameList) == null) {
            Intrinsics.checkNotNullParameter(frameList, "frameList");
        }
    }

    public Executor getExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.executor : (Executor) invokeV.objValue;
    }

    public int getIntervalFrameReplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }
}

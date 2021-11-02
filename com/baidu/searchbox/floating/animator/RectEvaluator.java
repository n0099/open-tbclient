package com.baidu.searchbox.floating.animator;

import android.animation.TypeEvaluator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/floating/animator/RectEvaluator;", "Landroid/animation/TypeEvaluator;", "", "fraction", "Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", "start", "end", "evaluate", "(FLcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;)Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", "<init>", "()V", "ViewRect", "lib-player-floating_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class RectEvaluator implements TypeEvaluator<ViewRect> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000B'\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0006\u0010\n\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\u0005R\u0019\u0010\b\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", "", "h", "I", "getH", "()I", "w", "getW", "x", "getX", "y", "getY", "<init>", "(IIII)V", "lib-player-floating_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class ViewRect {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final int f42834h;
        public final int w;
        public final int x;
        public final int y;

        public ViewRect(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.x = i2;
            this.y = i3;
            this.w = i4;
            this.f42834h = i5;
        }

        public final int getH() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f42834h : invokeV.intValue;
        }

        public final int getW() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w : invokeV.intValue;
        }

        public final int getX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.x : invokeV.intValue;
        }

        public final int getY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.y : invokeV.intValue;
        }
    }

    public RectEvaluator() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    public ViewRect evaluate(float f2, ViewRect viewRect, ViewRect viewRect2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), viewRect, viewRect2})) == null) ? new ViewRect((int) (viewRect.getX() + ((viewRect2.getX() - viewRect.getX()) * f2)), (int) (viewRect.getY() + ((viewRect2.getY() - viewRect.getY()) * f2)), (int) (viewRect.getW() + ((viewRect2.getW() - viewRect.getW()) * f2)), (int) (viewRect.getH() + (f2 * (viewRect2.getH() - viewRect.getH())))) : (ViewRect) invokeCommon.objValue;
    }
}

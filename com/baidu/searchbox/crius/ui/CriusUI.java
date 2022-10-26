package com.baidu.searchbox.crius.ui;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.crius.CriusNode;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class CriusUI implements RenderImplInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CriusUI";
    public transient /* synthetic */ FieldHolder $fh;
    public View mView;
    public CriusData renderObject;

    public abstract View createView(Context context);

    @Override // com.baidu.searchbox.crius.ui.RenderImplInterface
    public void insertChild(CriusData criusData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, criusData, i) == null) {
        }
    }

    @Override // com.baidu.searchbox.crius.ui.RenderImplInterface
    public void removeChild(CriusData criusData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, criusData) == null) {
        }
    }

    public CriusUI(Context context, CriusData criusData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, criusData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.renderObject = criusData;
        this.mView = createView(context);
    }

    private void setHScrollChildLp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int layoutWidth = (int) this.renderObject.criusNode.getLayoutWidth();
            int layoutHeight = (int) this.renderObject.criusNode.getLayoutHeight();
            ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = layoutWidth;
                layoutParams.height = layoutHeight;
                return;
            }
            this.mView.setLayoutParams(new RecyclerView.LayoutParams(layoutWidth, layoutHeight));
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mView = null;
        }
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mView;
        }
        return (View) invokeV.objValue;
    }

    public void setViewLp() {
        CriusData criusData;
        CriusData criusData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (criusData = this.renderObject) != null && (criusData2 = criusData.parent) != null && criusData2.isHScroll()) {
            setHScrollChildLp();
        }
    }

    public View getChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            View view2 = this.mView;
            if (view2 instanceof ViewGroup) {
                return ((ViewGroup) view2).getChildAt(i);
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    @Override // com.baidu.searchbox.crius.ui.RenderImplInterface
    public void layout(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            CriusData criusData = this.renderObject.parent;
            if (criusData != null && criusData.isSwiper()) {
                if (CriusRuntime.DEBUG) {
                    Log.d(TAG, "#layoutExp#, parent is swiper, layout nothing...");
                    return;
                }
                return;
            }
            CriusData criusData2 = this.renderObject.parent;
            if (criusData2 != null && criusData2.isHScroll()) {
                if (CriusRuntime.DEBUG) {
                    Log.d(TAG, "#layoutExp#, parent is RecyclerView, layout nothing...");
                    return;
                }
                return;
            }
            CriusNode criusNode = this.renderObject.criusNode;
            View view2 = (View) criusNode.getData();
            if (view2 != null && view2.getVisibility() != 8) {
                int round = Math.round(f + criusNode.getLayoutX());
                int round2 = Math.round(f2 + criusNode.getLayoutY());
                view2.measure(View.MeasureSpec.makeMeasureSpec(Math.round(criusNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(criusNode.getLayoutHeight()), 1073741824));
                if (CriusRuntime.DEBUG) {
                    Log.d(TAG, "#layoutExp#, type=" + this.renderObject.type + ", left=" + round + ", top=" + round2 + ", right=" + (view2.getMeasuredWidth() + round) + ", bottom=" + (view2.getMeasuredHeight() + round2));
                }
                view2.layout(round, round2, view2.getMeasuredWidth() + round, view2.getMeasuredHeight() + round2);
            }
        }
    }
}

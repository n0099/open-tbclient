package com.baidu.android.ext.widget.toast.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ReplaceViewHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public View mReplaceView;
    public View mTargetView;

    public ReplaceViewHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mReplaceView = null;
    }

    public final View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mReplaceView;
        }
        return (View) invokeV.objValue;
    }

    public ReplaceViewHelper(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mReplaceView = null;
        this.mContext = context;
    }

    public final ReplaceViewHelper removeView() {
        InterceptResult invokeV;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mReplaceView != null && (view2 = this.mTargetView) != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.mTargetView.getParent()).removeView(this.mReplaceView);
                this.mReplaceView = null;
                this.mTargetView.setVisibility(0);
            }
            return this;
        }
        return (ReplaceViewHelper) invokeV.objValue;
    }

    public ReplaceViewHelper toReplaceView(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i)) == null) {
            toReplaceView(view2, View.inflate(this.mContext, i, null));
            return this;
        }
        return (ReplaceViewHelper) invokeLI.objValue;
    }

    public ReplaceViewHelper toReplaceView(View view2, View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, view3)) == null) {
            this.mTargetView = view2;
            if (view2 == null) {
                return this;
            }
            if (!(view2.getParent() instanceof ViewGroup)) {
                return this;
            }
            ViewGroup viewGroup = (ViewGroup) this.mTargetView.getParent();
            int indexOfChild = viewGroup.indexOfChild(this.mTargetView);
            View view4 = this.mReplaceView;
            if (view4 != null) {
                viewGroup.removeView(view4);
            }
            this.mReplaceView = view3;
            view3.setLayoutParams(this.mTargetView.getLayoutParams());
            viewGroup.addView(this.mReplaceView, indexOfChild);
            if (viewGroup instanceof RelativeLayout) {
                this.mTargetView.setVisibility(4);
            } else {
                this.mTargetView.setVisibility(8);
            }
            return this;
        }
        return (ReplaceViewHelper) invokeLL.objValue;
    }
}

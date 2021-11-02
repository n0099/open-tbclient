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
/* loaded from: classes6.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mReplaceView : (View) invokeV.objValue;
    }

    public final ReplaceViewHelper removeView() {
        InterceptResult invokeV;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mReplaceView != null && (view = this.mTargetView) != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.mTargetView.getParent()).removeView(this.mReplaceView);
                this.mReplaceView = null;
                this.mTargetView.setVisibility(0);
            }
            return this;
        }
        return (ReplaceViewHelper) invokeV.objValue;
    }

    public ReplaceViewHelper toReplaceView(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2)) == null) {
            toReplaceView(view, View.inflate(this.mContext, i2, null));
            return this;
        }
        return (ReplaceViewHelper) invokeLI.objValue;
    }

    public ReplaceViewHelper toReplaceView(View view, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, view2)) == null) {
            this.mTargetView = view;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) this.mTargetView.getParent();
                int indexOfChild = viewGroup.indexOfChild(this.mTargetView);
                View view3 = this.mReplaceView;
                if (view3 != null) {
                    viewGroup.removeView(view3);
                }
                this.mReplaceView = view2;
                view2.setLayoutParams(this.mTargetView.getLayoutParams());
                viewGroup.addView(this.mReplaceView, indexOfChild);
                if (viewGroup instanceof RelativeLayout) {
                    this.mTargetView.setVisibility(4);
                } else {
                    this.mTargetView.setVisibility(8);
                }
                return this;
            }
            return this;
        }
        return (ReplaceViewHelper) invokeLL.objValue;
    }

    public ReplaceViewHelper(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mReplaceView = null;
        this.mContext = context;
    }
}

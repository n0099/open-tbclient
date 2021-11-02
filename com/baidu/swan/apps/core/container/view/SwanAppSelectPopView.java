package com.baidu.swan.apps.core.container.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes8.dex */
public class SwanAppSelectPopView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SELECTION_PADDING = 22;
    public static final int SELECTION_TOP_DUR = 3000;
    public transient /* synthetic */ FieldHolder $fh;
    public View mCopyView;
    public a mListener;
    public int mPopBottomY;
    public int mPopLeftX;
    public int mPopRightX;
    public int mPopTopY;
    public int mPopX;
    public int mPopY;
    public View mSearchView;
    public String mSelection;

    /* loaded from: classes8.dex */
    public interface a {
        void doSelectionCopy(String str);

        void doSelectionSearch(String str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanAppSelectPopView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int getPopBottomY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPopBottomY : invokeV.intValue;
    }

    public int getPopLeftX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPopLeftX : invokeV.intValue;
    }

    public int getPopRightX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPopRightX : invokeV.intValue;
    }

    public int getPopTopY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPopTopY : invokeV.intValue;
    }

    public int getPopX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPopX : invokeV.intValue;
    }

    public int getPopY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPopY : invokeV.intValue;
    }

    public String getSelection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSelection : (String) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            if (view.equals(this.mCopyView)) {
                a aVar2 = this.mListener;
                if (aVar2 != null) {
                    aVar2.doSelectionCopy(this.mSelection);
                }
            } else if (!view.equals(this.mSearchView) || (aVar = this.mListener) == null) {
            } else {
                aVar.doSelectionSearch(this.mSelection);
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onFinishInflate();
            View findViewById = findViewById(f.btn_wv_copy);
            this.mCopyView = findViewById;
            findViewById.setOnClickListener(this);
            View findViewById2 = findViewById(f.btn_wv_search);
            this.mSearchView = findViewById2;
            findViewById2.setOnClickListener(this);
        }
    }

    public void setEventListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.mListener = aVar;
        }
    }

    public void setPopBottomY(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mPopBottomY = i2;
        }
    }

    public void setPopLeftX(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mPopLeftX = i2;
        }
    }

    public void setPopRightX(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mPopRightX = i2;
        }
    }

    public void setPopTopY(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mPopTopY = i2;
        }
    }

    public void setPopX(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mPopX = i2;
        }
    }

    public void setPopY(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mPopY = i2;
        }
    }

    public void setSelection(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mSelection = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppSelectPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}

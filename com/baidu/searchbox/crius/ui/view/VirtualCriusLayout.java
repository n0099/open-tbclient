package com.baidu.searchbox.crius.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.parser.CriusDataFactory;
import com.baidu.searchbox.crius.ui.view.CriusLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class VirtualCriusLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<View> mChildren;
    public CriusData mCriusData;
    public Map<View, CriusData> mCriusDatas;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VirtualCriusLayout(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VirtualCriusLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualCriusLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mChildren = new LinkedList();
        this.mCriusDatas = new HashMap();
        this.mCriusData = CriusDataFactory.create(context, this);
        CriusLayout.applyLayoutParams(new CriusLayout.LayoutParams(context, attributeSet), this.mCriusData.criusNode, this);
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, layoutParams) == null) {
            if (view2 instanceof VirtualCriusLayout) {
                VirtualCriusLayout virtualCriusLayout = (VirtualCriusLayout) view2;
                virtualCriusLayout.transferChildren(this);
                if (!this.mCriusDatas.containsKey(view2)) {
                    CriusData criusData = virtualCriusLayout.getCriusData();
                    CriusData criusData2 = this.mCriusData;
                    criusData2.addChildAt(criusData, criusData2.getChildCount());
                }
            } else if (this.mCriusDatas.containsKey(view2)) {
                CriusData criusData3 = this.mCriusDatas.get(view2);
                CriusLayout.applyLayoutParams((CriusLayout.LayoutParams) view2.getLayoutParams(), criusData3.criusNode, view2);
                criusData3.criusNode.setData(view2);
                criusData3.criusNode.setMeasureFunction(new CriusLayout.ViewMeasureFunction());
                addView(view2, criusData3);
            } else {
                CriusData create = CriusDataFactory.create(getContext(), view2);
                CriusLayout.applyLayoutParams(new CriusLayout.LayoutParams(layoutParams), create.criusNode, view2);
                create.criusNode.setData(view2);
                create.criusNode.setMeasureFunction(new CriusLayout.ViewMeasureFunction());
                CriusData criusData4 = this.mCriusData;
                criusData4.addChildAt(create, criusData4.getChildCount());
                addView(view2, create);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualCriusLayout(Context context, CriusData criusData) {
        super(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, criusData};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mChildren = new LinkedList();
        this.mCriusDatas = new HashMap();
        this.mCriusData = criusData;
    }

    public void addView(View view2, int i, CriusData criusData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, criusData) == null) {
            this.mCriusDatas.put(view2, criusData);
            addView(view2, i);
        }
    }

    public void addView(View view2, CriusData criusData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, criusData) == null) {
            this.mChildren.add(view2);
            this.mCriusDatas.put(view2, criusData);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layoutParams)) == null) {
            return layoutParams instanceof CriusLayout.LayoutParams;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, attributeSet)) == null) {
            return new CriusLayout.LayoutParams(getContext(), attributeSet);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new CriusLayout.LayoutParams(-1, -1);
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public CriusData getCriusData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mCriusData;
        }
        return (CriusData) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, layoutParams)) == null) {
            return new CriusLayout.LayoutParams(layoutParams);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) != null) || !AppConfig.isDebug()) {
            return;
        }
        throw new RuntimeException("Attempting to layout a VirtualCriusLayout");
    }

    public void transferChildren(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewGroup) == null) {
            if (viewGroup instanceof VirtualCriusLayout) {
                for (View view2 : this.mChildren) {
                    ((VirtualCriusLayout) viewGroup).addView(view2, this.mCriusDatas.get(view2));
                }
            } else if (viewGroup instanceof CriusLayout) {
                for (View view3 : this.mChildren) {
                    ((CriusLayout) viewGroup).addView(view3, this.mCriusDatas.get(view3));
                }
            } else if (CriusRuntime.DEBUG) {
                throw new RuntimeException("VirtualCriusLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualCriusLayout or a CriusLayout.");
            }
            this.mChildren.clear();
        }
    }
}

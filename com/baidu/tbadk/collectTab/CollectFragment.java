package com.baidu.tbadk.collectTab;

import android.os.Bundle;
import c.a.e.e.p.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class CollectFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EDITOR_ENABLE_EXTRA = "is_enable_edit";
    public static final String EDITOR_STATE_EXTRA = "is_edit_state";
    public static final String FRAGMENT_TYPE = "fragment_type";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f47363e;
    public boolean mIsEnableEdit;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CollectFragment f47364a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CollectFragment collectFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {collectFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47364a = collectFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                CollectFragment collectFragment = this.f47364a;
                collectFragment.sendEditEnableMessage(collectFragment.getType());
                CollectFragment collectFragment2 = this.f47364a;
                if (collectFragment2.mIsEnableEdit) {
                    return;
                }
                collectFragment2.sendEditStateMessage(false, collectFragment2.getType());
            }
        }
    }

    public CollectFragment() {
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
        this.mIsEnableEdit = false;
        this.f47363e = new a(this, 2000994);
    }

    public abstract int getType();

    public abstract boolean isEmptyData();

    public boolean isEnableEdit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsEnableEdit : invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onStart();
            registerListener(this.f47363e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStop();
            MessageManager.getInstance().unRegisterListener(this.f47363e);
        }
    }

    public void sendEditEnableMessage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            Bundle bundle = new Bundle();
            boolean z = !isEmptyData() && j.z();
            this.mIsEnableEdit = z;
            bundle.putBoolean(EDITOR_ENABLE_EXTRA, z);
            bundle.putInt(FRAGMENT_TYPE, i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022209, bundle));
        }
    }

    public void sendEditStateMessage(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(EDITOR_STATE_EXTRA, z);
            bundle.putInt(FRAGMENT_TYPE, i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
        }
    }
}

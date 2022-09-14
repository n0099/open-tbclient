package com.baidu.adp.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ej;
import com.baidu.tieba.ho;
import com.baidu.tieba.ll;
import com.baidu.tieba.m9;
import com.baidu.tieba.n9;
import com.baidu.tieba.pb;
import com.baidu.tieba.s9;
import com.baidu.tieba.t9;
import com.baidu.tieba.u9;
import com.baidu.tieba.v9;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class BdBaseFragmentActivity<T> extends FragmentActivity implements View.OnClickListener, View.OnLongClickListener, s9<T>, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DialogInterface.OnClickListener, v9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PRELOAD_DELAY = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public u9 iPageLifecycleCallback;
    public final Handler mHandler;
    public BdUniqueId mId;
    public boolean mIsScroll;
    public final Runnable preLoadRunnable;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdBaseFragmentActivity a;

        public a(BdBaseFragmentActivity bdBaseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdBaseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdBaseFragmentActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdBaseFragmentActivity bdBaseFragmentActivity = this.a;
                bdBaseFragmentActivity.onPreLoad(bdBaseFragmentActivity.onGetPreLoadListView());
            }
        }
    }

    public BdBaseFragmentActivity() {
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
        this.mId = null;
        this.mIsScroll = false;
        this.mHandler = new Handler();
        this.preLoadRunnable = new a(this);
    }

    private void refreshImage(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, view2) == null) || view2 == null) {
            return;
        }
        if (view2 instanceof ll) {
            ((ll) view2).refresh();
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                refreshImage(viewGroup.getChildAt(i));
            }
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (Activity) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Resources resources = t9.a().getResources();
            return (resources == null || !BdBaseApplication.getInst().getIsPluginResourcOpen()) ? super.getResources() : resources;
        }
        return (Resources) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v9
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mId : (BdUniqueId) invokeV.objValue;
    }

    public void initUniqueId() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.mId == null) {
            this.mId = BdUniqueId.gen();
        }
    }

    @Override // com.baidu.tieba.v9
    public boolean isScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mIsScroll : invokeV.booleanValue;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, dialogInterface, i) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            m9.b(this);
            super.onCreate(bundle);
            if (this.mId == null) {
                this.mId = BdUniqueId.gen();
            }
            n9.g().o(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            u9 u9Var = this.iPageLifecycleCallback;
            if (u9Var != null) {
                u9Var.onDestroy();
            }
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.mId);
            MessageManager.getInstance().removeMessage(this.mId);
            zg.h().b(this.mId);
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            n9.g().m(getPageContext().getPageActivity());
        }
    }

    public ho onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (ho) invokeV.objValue;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            zg.h().e(this.mId);
            this.mHandler.removeCallbacks(this.preLoadRunnable);
        }
    }

    @Override // com.baidu.tieba.v9
    public void onPreLoad(ho hoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hoVar) == null) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            onResumeLoadResource();
        }
    }

    public void onResumeLoadResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            int childCount = frameLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                refreshImage(frameLayout.getChildAt(i));
            }
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            this.mHandler.postDelayed(this.preLoadRunnable, 100L);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStop();
            ho onGetPreLoadListView = onGetPreLoadListView();
            if (onGetPreLoadListView != null) {
                onGetPreLoadListView.cancelRefresh();
            }
        }
    }

    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(messageListener);
        }
    }

    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, message) == null) || message == null) {
            return;
        }
        if (message.getTag() == null) {
            message.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(message);
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    super.setContentView(i);
                    return;
                } catch (OutOfMemoryError e) {
                    if (i2 != 2) {
                        BdBaseApplication.getInst().onAppMemoryLow();
                    } else {
                        throw e;
                    }
                } catch (RuntimeException e2) {
                    if (i2 != 2) {
                        BdBaseApplication.getInst().onAppMemoryLow();
                    } else {
                        throw e2;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.v9
    public void setIsScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.mIsScroll = z;
        }
    }

    public void setPageLifecycleCallback(u9 u9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, u9Var) == null) {
            this.iPageLifecycleCallback = u9Var;
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            if (m9.d(this) && m9.a(i)) {
                return;
            }
            super.setRequestedOrientation(i);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bdUniqueId) == null) {
            this.mId = bdUniqueId;
        }
    }

    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            ej.N(getApplicationContext(), str);
        }
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(i, messageListener);
        }
    }

    public void sendMessage(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, netMessage) == null) || netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }

    public void registerListener(pb pbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, pbVar) == null) {
            if (pbVar != null && pbVar.getTag() == null) {
                pbVar.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(pbVar);
        }
    }

    public void registerListener(int i, pb pbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, pbVar) == null) {
            if (pbVar != null && pbVar.getTag() == null) {
                pbVar.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(i, pbVar);
        }
    }
}

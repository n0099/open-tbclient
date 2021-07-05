package com.baidu.adp.plugin.pluginBase;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.b;
import d.a.c.a.h;
import d.a.c.a.i;
import d.a.c.e.l.d;
import d.a.c.e.p.l;
import d.a.c.k.e.q;
/* loaded from: classes.dex */
public abstract class PluginAdpBaseFragmentActivity extends PluginBaseFragmentActivity implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DialogInterface.OnClickListener, i {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PRELOAD_DELAY = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler mHandler;
    public BdUniqueId mId;
    public boolean mIsScroll;
    public final Runnable preLoadRunnable;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PluginAdpBaseFragmentActivity f2255e;

        public a(PluginAdpBaseFragmentActivity pluginAdpBaseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginAdpBaseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2255e = pluginAdpBaseFragmentActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PluginAdpBaseFragmentActivity pluginAdpBaseFragmentActivity = this.f2255e;
                pluginAdpBaseFragmentActivity.onPreLoad(pluginAdpBaseFragmentActivity.onGetPreLoadListView());
            }
        }
    }

    public PluginAdpBaseFragmentActivity() {
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
        this.mId = null;
        this.mIsScroll = false;
        this.mHandler = new Handler();
        this.preLoadRunnable = new a(this);
    }

    private void refreshImage(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, view) == null) || view == null) {
            return;
        }
        if (view instanceof d.a.c.f.a.i) {
            ((d.a.c.f.a.i) view).refresh();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                refreshImage(viewGroup.getChildAt(i2));
            }
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginContextWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Resources b2 = h.a().b();
            return (b2 == null || !BdBaseApplication.getInst().getIsPluginResourcOpen()) ? super.getResources() : b2;
        }
        return (Resources) invokeV.objValue;
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, d.a.c.a.i
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mId : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, d.a.c.a.i
    public boolean isScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsScroll : invokeV.booleanValue;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, dialogInterface, i2) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            this.mId = BdUniqueId.gen();
            b.f().n(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.mId);
            MessageManager.getInstance().removeMessage(this.mId);
            d.h().b(this.mId);
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            b.f().l(getPageContext().getPageActivity());
        }
    }

    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (q) invokeV.objValue;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            d.h().e(this.mId);
            this.mHandler.removeCallbacks(this.preLoadRunnable);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, d.a.c.a.i
    public void onPreLoad(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, qVar) == null) {
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            onResumeLoadResource();
        }
    }

    public void onResumeLoadResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            int childCount = frameLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                refreshImage(frameLayout.getChildAt(i2));
            }
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            this.mHandler.postDelayed(this.preLoadRunnable, 100L);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStop();
            q onGetPreLoadListView = onGetPreLoadListView();
            if (onGetPreLoadListView != null) {
                onGetPreLoadListView.cancelRefresh();
            }
        }
    }

    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(messageListener);
        }
    }

    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, message) == null) || message == null) {
            return;
        }
        if (message.getTag() == null) {
            message.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(message);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void setContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            for (int i3 = 0; i3 < 3; i3++) {
                try {
                    super.setContentView(i2);
                    return;
                } catch (OutOfMemoryError e2) {
                    if (i3 != 2) {
                        BdBaseApplication.getInst().onAppMemoryLow();
                    } else {
                        throw e2;
                    }
                } catch (RuntimeException e3) {
                    if (i3 != 2) {
                        BdBaseApplication.getInst().onAppMemoryLow();
                    } else {
                        throw e3;
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, d.a.c.a.i
    public void setIsScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.mIsScroll = z;
        }
    }

    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            l.M(getApplicationContext(), str);
        }
    }

    public void registerListener(int i2, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(i2, messageListener);
        }
    }

    public void sendMessage(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, netMessage) == null) || netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }

    public void registerListener(d.a.c.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            if (aVar != null && aVar.getTag() == null) {
                aVar.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public void registerListener(int i2, d.a.c.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, aVar) == null) {
            if (aVar != null && aVar.getTag() == null) {
                aVar.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(i2, aVar);
        }
    }
}

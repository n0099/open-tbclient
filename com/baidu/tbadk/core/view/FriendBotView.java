package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.bi;
import com.baidu.tieba.k15;
import com.baidu.tieba.wb9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
import tbclient.CallRobotEntrance;
import tbclient.StyleConf;
import tbclient.StyleConfExtra;
import tbclient.StyleContentInfo;
/* loaded from: classes4.dex */
public class FriendBotView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImage a;
    public EMTextView b;
    public CallRobotEntrance c;
    public boolean d;
    public f e;
    public k15 f;
    public String g;
    public StyleContentInfo h;
    public String i;
    public final Runnable j;
    public final ViewTreeObserver.OnScrollChangedListener k;
    public View.OnClickListener l;
    public View.OnLongClickListener m;

    /* loaded from: classes4.dex */
    public interface f {
        void a(boolean z);

        void b(boolean z, boolean z2, String str);
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FriendBotView a;

        public a(FriendBotView friendBotView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {friendBotView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = friendBotView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.u();
            this.a.j();
            this.a.d = false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FriendBotView a;

        public b(FriendBotView friendBotView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {friendBotView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = friendBotView;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.isAttachedToWindow() || this.a.getGlobalVisibleRect(new Rect())) {
                return;
            }
            this.a.u();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FriendBotView a;

        public c(FriendBotView friendBotView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {friendBotView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = friendBotView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e != null) {
                if (this.a.c != null && this.a.c.style_conf != null && this.a.c.style_conf.android_extra != null) {
                    str = this.a.c.style_conf.android_extra.bot_loading_toast;
                } else {
                    str = "";
                }
                this.a.e.b(this.a.d, this.a.f.d(), str);
                if (!this.a.d && !this.a.f.d()) {
                    this.a.x();
                    this.a.u();
                    this.a.d = true;
                    SafeHandler.getInst().removeCallbacks(this.a.j);
                    SafeHandler.getInst().postDelayed(this.a.j, 30000L);
                    this.a.s();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FriendBotView a;

        public d(FriendBotView friendBotView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {friendBotView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = friendBotView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.a.e != null) {
                    this.a.e.a(this.a.d);
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FriendBotView a;

        public e(FriendBotView friendBotView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {friendBotView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = friendBotView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (Unit) invokeV.objValue;
            }
            this.a.u();
            return null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FriendBotView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setCallRobotEntranceData(k15 k15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, k15Var) == null) {
            this.f = k15Var;
            this.c = k15Var.c();
            setStyleContentInfo(k15Var);
            setLoadingToast(this.c);
            p();
            if (this.b.getVisibility() == 0) {
                this.b.setText(getBotContent());
                w();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FriendBotView(Context context, AttributeSet attributeSet) {
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
    public FriendBotView(Context context, AttributeSet attributeSet, int i) {
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
        this.d = false;
        this.j = new a(this);
        this.k = new b(this);
        this.l = new c(this);
        this.m = new d(this);
        m(context);
    }

    private void setBotTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, this, i) == null) {
            EMManager.from(this.b).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            this.b.setTextColor(i);
        }
    }

    private void setLoadingToast(CallRobotEntrance callRobotEntrance) {
        StyleConf styleConf;
        StyleConfExtra styleConfExtra;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, this, callRobotEntrance) == null) && callRobotEntrance != null && (styleConf = callRobotEntrance.style_conf) != null && (styleConfExtra = styleConf.android_extra) != null) {
            this.i = styleConfExtra.bot_loading_toast;
        }
    }

    private void setStyleContentInfo(k15 k15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, k15Var) == null) {
            if (TbadkApplication.getInst().getSkinType() == 4) {
                this.h = k15Var.a();
            } else {
                this.h = k15Var.b();
            }
        }
    }

    public void k(CallRobotEntrance callRobotEntrance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, callRobotEntrance) == null) {
            SafeHandler.getInst().removeCallbacks(this.j);
            this.c = callRobotEntrance;
            this.b.setText(getBotContent());
            u();
            this.d = false;
            w();
        }
    }

    public void setClickCallBack(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.e = fVar;
        }
    }

    public void setDynamicLooping(boolean z) {
        TbImage tbImage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && (tbImage = this.a) != null) {
            tbImage.setLooping(z);
        }
    }

    public void setRobotEntrance(CallRobotEntrance callRobotEntrance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, callRobotEntrance) == null) {
            this.c = callRobotEntrance;
            this.b.setText(getBotContent());
            p();
            w();
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.g = str;
        }
    }

    private String getBotContent() {
        InterceptResult invokeV;
        StyleConf styleConf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            CallRobotEntrance callRobotEntrance = this.c;
            if (callRobotEntrance != null && (styleConf = callRobotEntrance.style_conf) != null) {
                return styleConf.content;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public Runnable getAshRunnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (Runnable) invokeV.objValue;
    }

    public String getLoadingToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public CallRobotEntrance getRobotEntrance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (CallRobotEntrance) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            EMTextView eMTextView = this.b;
            if (eMTextView != null) {
                eMTextView.setVisibility(8);
            }
            TbImage tbImage = this.a;
            if (tbImage != null) {
                ViewGroup.LayoutParams layoutParams = tbImage.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.a.requestLayout();
            }
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            getViewTreeObserver().addOnScrollChangedListener(this.k);
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            getViewTreeObserver().removeOnScrollChangedListener(this.k);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d = n();
            u();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            setStyleContentInfo(this.f);
            u();
            w();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            SharedPrefHelper.getInstance().putLong("friend_bot_guide_show", System.currentTimeMillis());
        }
    }

    public final void u() {
        StyleContentInfo styleContentInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (styleContentInfo = this.h) != null) {
            String str = styleContentInfo.icon;
            String str2 = styleContentInfo.dynamic_icon;
            if (!bi.isEmpty(str2)) {
                this.a.l(str2);
            }
            if (!TextUtils.isEmpty(str)) {
                this.a.k(str);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.a.setOnWebpEndedListener(new e(this));
        }
    }

    public void x() {
        TbImage tbImage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (tbImage = this.a) != null) {
            tbImage.p();
            u();
        }
    }

    public final void j() {
        Map<String, Long> b2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (b2 = wb9.b()) == null) {
            return;
        }
        Iterator<Map.Entry<String, Long>> it = b2.entrySet().iterator();
        while (it.hasNext()) {
            if (System.currentTimeMillis() - it.next().getValue().longValue() > 30000) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                it.remove();
            }
        }
        SharedPrefHelper.getInstance().putString("friend_bot_sha_time_tids", new JSONObject(b2).toString());
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = "friend_bot_sha_time" + this.g;
            Map<String, Long> b2 = wb9.b();
            if (b2 != null && b2.containsKey(str)) {
                long currentTimeMillis = System.currentTimeMillis() - b2.get(str).longValue();
                if (currentTimeMillis >= 0 && currentTimeMillis < 30000) {
                    SafeHandler.getInst().removeCallbacks(this.j);
                    SafeHandler.getInst().postDelayed(this.j, 30000 - currentTimeMillis);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            String str = "friend_bot_sha_time" + this.g;
            Map b2 = wb9.b();
            if (b2 == null) {
                b2 = new HashMap();
            }
            b2.put(str, Long.valueOf(System.currentTimeMillis()));
            SharedPrefHelper.getInstance().putString("friend_bot_sha_time_tids", new JSONObject(b2).toString());
        }
    }

    public final void w() {
        StyleContentInfo styleContentInfo;
        String str;
        StyleContentInfo styleContentInfo2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            CallRobotEntrance callRobotEntrance = this.c;
            if (callRobotEntrance == null) {
                setBotTextColor(R.color.CAM_X0107);
                return;
            }
            StyleConf styleConf = callRobotEntrance.style_conf;
            if (styleConf != null && (styleContentInfo = styleConf.day) != null && (str = styleContentInfo.content_color) != null && (styleContentInfo2 = styleConf.dark) != null && (str2 = styleContentInfo2.content_color) != null) {
                if (skinType == 4) {
                    if (!TextUtils.isEmpty(str2)) {
                        setBotTextColor(Color.parseColor(styleConf.dark.content_color));
                        return;
                    }
                    return;
                } else if (!TextUtils.isEmpty(str)) {
                    setBotTextColor(Color.parseColor(styleConf.day.content_color));
                    return;
                } else {
                    return;
                }
            }
            setBotTextColor(R.color.CAM_X0107);
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.pb_friend_bot_view, (ViewGroup) this, true);
            setClipChildren(false);
            setClipToPadding(false);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.pb_friend_bot_container);
            this.a = (TbImage) findViewById(R.id.pb_friend_bot_image);
            this.b = (EMTextView) findViewById(R.id.pb_friend_bot_content);
            this.a.setLooping(false);
            linearLayout.setOnClickListener(this.l);
            linearLayout.setOnLongClickListener(this.m);
            v();
            j();
        }
    }

    public void r() {
        StyleContentInfo styleContentInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.a != null && (styleContentInfo = this.h) != null) {
            String str = styleContentInfo.dynamic_icon;
            if (!TextUtils.isEmpty(str)) {
                this.a.setCurFrameToPLaceHolder();
                this.a.k(str);
                this.a.o();
                return;
            }
            u();
        }
    }
}

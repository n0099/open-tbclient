package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.data.FriendBotPostConfigData;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.r95;
import com.baidu.tieba.s75;
import com.baidu.tieba.u79;
import com.baidu.tieba.yg;
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
import tbclient.StyleContentInfo;
/* loaded from: classes4.dex */
public class FriendBotView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImage a;
    public EMTextView b;
    public CallRobotEntrance c;
    public boolean d;
    public d e;
    public String f;
    public Runnable g;
    public final ViewTreeObserver.OnScrollChangedListener h;

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, String str);
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
            this.a.r();
            this.a.d = true;
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
            this.a.t();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Function0<Unit> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (Unit) invokeV.objValue;
            }
            this.a.r();
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

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.pb_friend_bot_view, (ViewGroup) this, true);
            setClipChildren(false);
            setClipToPadding(false);
            this.a = (TbImage) findViewById(R.id.pb_friend_bot_image);
            this.b = (EMTextView) findViewById(R.id.pb_friend_bot_content);
            this.a.setLooping(false);
            s();
            d();
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
        this.d = true;
        this.g = new a(this);
        this.h = new b(this);
        h(context);
    }

    private void setBotTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            s75 d2 = s75.d(this.b);
            d2.C(R.dimen.T_X09);
            d2.D(R.string.F_X01);
            this.b.setTextColor(i);
        }
    }

    public void e(CallRobotEntrance callRobotEntrance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callRobotEntrance) == null) {
            this.c = callRobotEntrance;
            this.b.setText(getBotContent());
            r();
            this.d = true;
            u();
        }
    }

    public void setClickCallBack(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dVar) == null) {
            this.e = dVar;
        }
    }

    public void setRobotEntrance(CallRobotEntrance callRobotEntrance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, callRobotEntrance) == null) {
            this.c = callRobotEntrance;
            this.b.setText(getBotContent());
            k();
            u();
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f = str;
        }
    }

    private String getBotContent() {
        InterceptResult invokeV;
        StyleConf styleConf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            CallRobotEntrance callRobotEntrance = this.c;
            if (callRobotEntrance != null && (styleConf = callRobotEntrance.style_conf) != null) {
                return styleConf.content;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    private String getBotDynamicResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            FriendBotPostConfigData friendBotPostConfigData = TbSingleton.getInstance().getFriendBotPostConfigData();
            if (friendBotPostConfigData != null) {
                return friendBotPostConfigData.getDynamicButtonResource();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public Runnable getAshRunnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (Runnable) invokeV.objValue;
    }

    public CallRobotEntrance getRobotEntrance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (CallRobotEntrance) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (i()) {
                q();
                this.d = false;
                return;
            }
            if (l()) {
                p();
            } else {
                r();
            }
            this.d = true;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t();
            u();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            r95.p().H("friend_bot_guide_show", System.currentTimeMillis());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            getViewTreeObserver().addOnScrollChangedListener(this.h);
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetachedFromWindow();
            getViewTreeObserver().removeOnScrollChangedListener(this.h);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            t();
            this.a.setAlpha(0.3f);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            t();
            this.a.setAlpha(1.0f);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.a.setOnWebpEndedListener(new c(this));
        }
    }

    public final void t() {
        CallRobotEntrance callRobotEntrance;
        StyleConf styleConf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (callRobotEntrance = this.c) != null && (styleConf = callRobotEntrance.style_conf) != null) {
            String f = f(styleConf);
            if (!TextUtils.isEmpty(f)) {
                this.a.k(f);
            }
        }
    }

    public final void d() {
        Map<String, Long> b2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (b2 = u79.b()) == null) {
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
        r95.p().J("friend_bot_sha_time_tids", new JSONObject(b2).toString());
    }

    public void g() {
        String str;
        StyleConf styleConf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(getContext());
                return;
            }
            if (this.e != null) {
                CallRobotEntrance callRobotEntrance = this.c;
                if (callRobotEntrance != null && (styleConf = callRobotEntrance.style_conf) != null) {
                    str = f(styleConf);
                } else {
                    str = "";
                }
                this.e.a(this.d, str);
            }
            if (this.d) {
                this.a.p();
                q();
                this.d = false;
                yg.a().removeCallbacks(this.g);
                yg.a().postDelayed(this.g, 30000L);
                n();
            }
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = "friend_bot_sha_time" + this.f;
            Map<String, Long> b2 = u79.b();
            if (b2 != null && b2.containsKey(str)) {
                long currentTimeMillis = System.currentTimeMillis() - b2.get(str).longValue();
                if (currentTimeMillis >= 0 && currentTimeMillis < 30000) {
                    yg.a().removeCallbacks(this.g);
                    yg.a().postDelayed(this.g, 30000 - currentTimeMillis);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FriendBotPostConfigData friendBotPostConfigData = TbSingleton.getInstance().getFriendBotPostConfigData();
            if (friendBotPostConfigData == null) {
                return false;
            }
            if (friendBotPostConfigData.getPbFirstFloorBotDynamicIconPlay() == null) {
                intValue = 0;
            } else {
                intValue = friendBotPostConfigData.getPbFirstFloorBotDynamicIconPlay().intValue();
            }
            if (intValue == 0) {
                return false;
            }
            if (intValue == 1) {
                long r = r95.p().r("pb_friend_bot_show", 0L);
                if (r < 0) {
                    return true;
                }
                return !TimeHelper.isSameDay(r, System.currentTimeMillis());
            } else if (intValue != 2) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String str = "friend_bot_sha_time" + this.f;
            Map b2 = u79.b();
            if (b2 == null) {
                b2 = new HashMap();
            }
            b2.put(str, Long.valueOf(System.currentTimeMillis()));
            r95.p().J("friend_bot_sha_time_tids", new JSONObject(b2).toString());
        }
    }

    public final void u() {
        StyleContentInfo styleContentInfo;
        String str;
        StyleContentInfo styleContentInfo2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
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

    public final String f(@NonNull StyleConf styleConf) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, styleConf)) == null) {
            if (TbadkApplication.getInst().getSkinType() == 4) {
                StyleContentInfo styleContentInfo = styleConf.dark;
                if (styleContentInfo != null && !TextUtils.isEmpty(styleContentInfo.icon)) {
                    str = styleConf.dark.icon;
                }
                str = null;
            } else {
                StyleContentInfo styleContentInfo2 = styleConf.day;
                if (styleContentInfo2 != null && !TextUtils.isEmpty(styleContentInfo2.icon)) {
                    str = styleConf.day.icon;
                }
                str = null;
            }
            if (StringUtils.isNull(str)) {
                return null;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            String botDynamicResource = getBotDynamicResource();
            if (!TextUtils.isEmpty(botDynamicResource)) {
                this.a.setAlpha(1.0f);
                this.a.k(botDynamicResource);
                this.a.o();
                r95.p().H("pb_friend_bot_show", System.currentTimeMillis());
            }
        }
    }
}

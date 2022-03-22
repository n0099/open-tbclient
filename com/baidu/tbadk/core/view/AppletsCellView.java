package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f29951b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f29952c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f29953d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f29954e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f29955f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f29956g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f29957h;
    public String i;
    public String j;
    public String k;

    /* loaded from: classes5.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AppletsCellView a;

        public a(AppletsCellView appletsCellView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appletsCellView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = appletsCellView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) || z) {
                return;
            }
            this.a.f29954e.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080f4a);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f29954e.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080f4a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppletsCellView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0123, (ViewGroup) this, true);
            this.f29951b = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090299);
            this.f29952c = (TextView) findViewById(R.id.obfuscated_res_0x7f09029b);
            this.f29953d = (TextView) findViewById(R.id.obfuscated_res_0x7f090298);
            this.f29954e = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09029a);
            this.f29955f = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f09029c);
            this.f29956g = (TextView) findViewById(R.id.obfuscated_res_0x7f09029d);
            this.f29951b.setIsRound(true);
            this.f29951b.setIsPreDrawBorder(true);
            this.f29951b.setDrawBorder(true);
            this.f29951b.setBorderWidth(n.f(context, R.dimen.tbds1));
            this.f29951b.setDefaultResource(R.color.CAM_X0205);
            this.f29951b.setRadius(n.f(context, R.dimen.obfuscated_res_0x7f070266));
            ViewGroup.LayoutParams layoutParams = this.f29954e.getLayoutParams();
            layoutParams.height = ((n.k(getContext()) - n.f(getContext(), R.dimen.tbds130)) * 9) / 16;
            this.f29954e.setLayoutParams(layoutParams);
            this.f29954e.setConrers(15);
            setOnClickListener(this);
            this.f29955f.setIsRound(true);
            this.f29955f.setDrawBorder(false);
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundResource(this, R.drawable.applets_cell_bg);
            this.f29951b.setBorderColor(SkinManager.getColor(R.color.CAM_X0201));
            this.f29951b.setSkinType(this.a);
            SkinManager.setViewTextColor(this.f29952c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f29953d, (int) R.color.CAM_X0105);
            this.f29954e.setSkinType(this.a);
            this.f29955f.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_avatar_smallapp_tie));
            this.f29955f.setBorderColor(SkinManager.getColor(R.color.CAM_X0201));
            this.f29955f.setSkinType(this.a);
            SkinManager.setViewTextColor(this.f29956g, (int) R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SmartApp smartApp;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || (smartApp = this.f29957h) == null) {
            return;
        }
        if (!c.a.p0.b0.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
            if (StringUtils.isNull(this.f29957h.h5_url)) {
                return;
            }
            c.a.o0.l.a.m(getContext(), this.f29957h.h5_url);
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.j).param("tid", this.k).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", this.f29957h.name).param("obj_id", this.f29957h.swan_app_id.longValue()).param("obj_source", this.i).param("obj_param1", this.f29957h.is_game.intValue()));
    }

    public void setData(SmartApp smartApp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, smartApp) == null) {
            if (smartApp == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f29957h = smartApp;
            this.f29951b.J(smartApp.avatar, 10, false);
            this.f29952c.setText(smartApp.name);
            if (StringUtils.isNull(smartApp._abstract, true)) {
                this.f29953d.setVisibility(8);
            } else {
                this.f29953d.setVisibility(0);
                this.f29953d.setText(smartApp._abstract);
            }
            if (StringUtils.isNull(smartApp.pic, true)) {
                this.f29954e.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080f4a);
                return;
            }
            this.f29954e.setEvent(new a(this));
            this.f29954e.J(smartApp.pic, 10, false);
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.j = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.i = str;
        }
    }

    public void setThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.k = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppletsCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppletsCellView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 3;
        b(context);
    }
}

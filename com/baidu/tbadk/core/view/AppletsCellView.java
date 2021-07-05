package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import d.a.c.e.p.l;
import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f12373e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f12374f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12375g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12376h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f12377i;
    public HeadImageView j;
    public TextView k;
    public SmartApp l;
    public String m;
    public String n;
    public String o;

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppletsCellView f12378a;

        public a(AppletsCellView appletsCellView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appletsCellView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12378a = appletsCellView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) || z) {
                return;
            }
            this.f12378a.f12377i.setDefaultBgResource(R.drawable.pic_share_default_applets);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f12378a.f12377i.setDefaultBgResource(R.drawable.pic_share_default_applets);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12373e = 3;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.applets_cell_layout, (ViewGroup) this, true);
            this.f12374f = (HeadImageView) findViewById(R.id.applets_app_icon);
            this.f12375g = (TextView) findViewById(R.id.applets_app_name);
            this.f12376h = (TextView) findViewById(R.id.applets_app_content);
            this.f12377i = (TbImageView) findViewById(R.id.applets_app_img);
            this.j = (HeadImageView) findViewById(R.id.applets_app_type_icon);
            this.k = (TextView) findViewById(R.id.applets_app_type_name);
            this.f12374f.setIsRound(true);
            this.f12374f.setIsPreDrawBorder(true);
            this.f12374f.setDrawBorder(true);
            this.f12374f.setBorderWidth(l.g(context, R.dimen.tbds1));
            this.f12374f.setDefaultResource(R.color.CAM_X0205);
            this.f12374f.setRadius(l.g(context, R.dimen.ds70));
            ViewGroup.LayoutParams layoutParams = this.f12377i.getLayoutParams();
            layoutParams.height = ((l.k(getContext()) - l.g(getContext(), R.dimen.tbds130)) * 9) / 16;
            this.f12377i.setLayoutParams(layoutParams);
            this.f12377i.setConrers(15);
            setOnClickListener(this);
            this.j.setIsRound(true);
            this.j.setDrawBorder(false);
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f12373e = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundResource(this, R.drawable.applets_cell_bg);
            this.f12374f.setBorderColor(SkinManager.getColor(R.color.CAM_X0201));
            this.f12374f.setIsNight(this.f12373e == 1);
            SkinManager.setViewTextColor(this.f12375g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f12376h, R.color.CAM_X0105);
            this.f12377i.setIsNight(this.f12373e == 1);
            this.j.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_avatar_smallapp_tie));
            this.j.setBorderColor(SkinManager.getColor(R.color.CAM_X0201));
            this.j.setIsNight(this.f12373e == 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SmartApp smartApp;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || (smartApp = this.l) == null) {
            return;
        }
        if (!d.a.s0.u.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
            if (StringUtils.isNull(this.l.h5_url)) {
                return;
            }
            d.a.r0.l.a.l(getContext(), this.l.h5_url);
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.n).param("tid", this.o).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", this.l.name).param("obj_id", this.l.swan_app_id.longValue()).param("obj_source", this.m).param("obj_param1", this.l.is_game.intValue()));
    }

    public void setData(SmartApp smartApp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, smartApp) == null) {
            if (smartApp == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.l = smartApp;
            this.f12374f.M(smartApp.avatar, 10, false);
            this.f12375g.setText(smartApp.name);
            if (StringUtils.isNull(smartApp._abstract, true)) {
                this.f12376h.setVisibility(8);
            } else {
                this.f12376h.setVisibility(0);
                this.f12376h.setText(smartApp._abstract);
            }
            if (StringUtils.isNull(smartApp.pic, true)) {
                this.f12377i.setDefaultBgResource(R.drawable.pic_share_default_applets);
                return;
            }
            this.f12377i.setEvent(new a(this));
            this.f12377i.M(smartApp.pic, 10, false);
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    public void setThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.o = str;
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
        this.f12373e = 3;
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppletsCellView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f12373e = 3;
        b(context);
    }
}

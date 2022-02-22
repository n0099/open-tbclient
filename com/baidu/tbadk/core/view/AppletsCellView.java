package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes11.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FRS_SHARE_CARD_LITE_PROGRAM_FROM = "frs_card";
    public static final String PB_SHARE_CARD_LITE_PROGRAM_FROM = "PB_card";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f40551e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f40552f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40553g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f40554h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f40555i;

    /* renamed from: j  reason: collision with root package name */
    public HeadImageView f40556j;
    public TextView k;
    public SmartApp l;
    public String m;
    public String n;
    public String o;

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            this.a.f40555i.setDefaultBgResource(f.pic_share_default_applets);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f40555i.setDefaultBgResource(f.pic_share_default_applets);
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
        this.f40551e = 3;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(h.applets_cell_layout, (ViewGroup) this, true);
            this.f40552f = (HeadImageView) findViewById(g.applets_app_icon);
            this.f40553g = (TextView) findViewById(g.applets_app_name);
            this.f40554h = (TextView) findViewById(g.applets_app_content);
            this.f40555i = (TbImageView) findViewById(g.applets_app_img);
            this.f40556j = (HeadImageView) findViewById(g.applets_app_type_icon);
            this.k = (TextView) findViewById(g.applets_app_type_name);
            this.f40552f.setIsRound(true);
            this.f40552f.setIsPreDrawBorder(true);
            this.f40552f.setDrawBorder(true);
            this.f40552f.setBorderWidth(n.f(context, e.tbds1));
            this.f40552f.setDefaultResource(d.CAM_X0205);
            this.f40552f.setRadius(n.f(context, e.ds70));
            ViewGroup.LayoutParams layoutParams = this.f40555i.getLayoutParams();
            layoutParams.height = ((n.k(getContext()) - n.f(getContext(), e.tbds130)) * 9) / 16;
            this.f40555i.setLayoutParams(layoutParams);
            this.f40555i.setConrers(15);
            setOnClickListener(this);
            this.f40556j.setIsRound(true);
            this.f40556j.setDrawBorder(false);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f40551e = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundResource(this, f.applets_cell_bg);
            this.f40552f.setBorderColor(SkinManager.getColor(d.CAM_X0201));
            this.f40552f.setSkinType(this.f40551e);
            SkinManager.setViewTextColor(this.f40553g, d.CAM_X0105);
            SkinManager.setViewTextColor(this.f40554h, d.CAM_X0105);
            this.f40555i.setSkinType(this.f40551e);
            this.f40556j.setImageDrawable(SkinManager.getDrawable(f.icon_avatar_smallapp_tie));
            this.f40556j.setBorderColor(SkinManager.getColor(d.CAM_X0201));
            this.f40556j.setSkinType(this.f40551e);
            SkinManager.setViewTextColor(this.k, d.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SmartApp smartApp;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || (smartApp = this.l) == null) {
            return;
        }
        if (!c.a.u0.z.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
            if (StringUtils.isNull(this.l.h5_url)) {
                return;
            }
            c.a.t0.m.a.m(getContext(), this.l.h5_url);
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
            this.f40552f.startLoad(smartApp.avatar, 10, false);
            this.f40553g.setText(smartApp.name);
            if (StringUtils.isNull(smartApp._abstract, true)) {
                this.f40554h.setVisibility(8);
            } else {
                this.f40554h.setVisibility(0);
                this.f40554h.setText(smartApp._abstract);
            }
            if (StringUtils.isNull(smartApp.pic, true)) {
                this.f40555i.setDefaultBgResource(f.pic_share_default_applets);
                return;
            }
            this.f40555i.setEvent(new a(this));
            this.f40555i.startLoad(smartApp.pic, 10, false);
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
        this.f40551e = 3;
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
        this.f40551e = 3;
        b(context);
    }
}

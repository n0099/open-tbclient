package b.a.r0.w.l.g.c.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.l.d;
import b.a.r0.w.l.g.c.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f25242a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f25243b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f25244c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.w.l.g.c.a f25245d;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f25246e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25247f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25248g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f25249h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f25250i;
    public ImageView j;
    public TextView k;
    public LinearLayout l;
    public AlaNetRefreshView m;
    public RelativeLayout n;
    public TextView o;
    public View p;
    public c q;
    public List<AlaLiveMarkData> r;
    public a.d s;

    /* renamed from: b.a.r0.w.l.g.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1232a extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25251a;

        public C1232a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25251a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((C1232a) aVar, str, i2);
                if (aVar == null || aVar.p() == null) {
                    return;
                }
                this.f25251a.f25249h.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f25251a.f25249h.setImageBitmap(BitmapHelper.fastblur(aVar.p(), 15, 0.75f));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25252a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25252a = aVar;
        }

        @Override // b.a.r0.w.l.g.c.a.d
        public void a(b.a.r0.w.l.g.c.b.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || this.f25252a.q == null) {
                return;
            }
            this.f25252a.q.a(bVar);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(b.a.r0.w.l.g.c.b.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new ArrayList();
        this.s = new b(this);
        this.f25243b = tbPageContext;
        this.q = cVar;
        e();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25242a : (View) invokeV.objValue;
    }

    public void d() {
        AlaNetRefreshView alaNetRefreshView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alaNetRefreshView = this.m) == null) {
            return;
        }
        alaNetRefreshView.dettachView(this.n);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f25243b.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
            this.f25242a = inflate;
            inflate.setPadding(0, (int) this.f25243b.getResources().getDimension(R.dimen.ds80), 0, 0);
            this.f25246e = (HeadImageView) this.f25242a.findViewById(R.id.ala_person_center_privilege_header_iv);
            this.f25247f = (TextView) this.f25242a.findViewById(R.id.ala_person_center_privilege_header_name_tv);
            this.f25248g = (TextView) this.f25242a.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
            this.f25249h = (TbImageView) this.f25242a.findViewById(R.id.ala_person_center_privilege_header_container_bg);
            this.n = (RelativeLayout) this.f25242a.findViewById(R.id.ala_person_center_privilege_mark_list_container);
            this.l = (LinearLayout) this.f25242a.findViewById(R.id.ala_person_center_privilege_header_has_wears);
            this.o = (TextView) this.f25242a.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
            this.j = (ImageView) this.f25242a.findViewById(R.id.empty_image);
            this.k = (TextView) this.f25242a.findViewById(R.id.empty_text);
            this.p = this.f25242a.findViewById(R.id.ala_person_center_privilege_mask);
            this.f25244c = (BdListView) this.f25242a.findViewById(R.id.ala_person_center_privilege_mark_list);
            b.a.r0.w.l.g.c.a aVar = new b.a.r0.w.l.g.c.a(this.f25243b, this.s);
            this.f25245d = aVar;
            this.f25244c.setAdapter((ListAdapter) aVar);
            RelativeLayout relativeLayout = (RelativeLayout) this.f25242a.findViewById(R.id.emptyview);
            this.f25250i = relativeLayout;
            this.f25244c.setEmptyView(relativeLayout);
            this.f25246e.setIsRound(true);
            this.f25246e.setDefaultBgResource(R.color.transparent);
            this.f25246e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f25249h.setDefaultBgResource(R.color.transparent);
            this.f25249h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.f25242a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f25247f, R.color.common_color_10310);
            SkinManager.setViewTextColor(this.f25248g, R.color.white_alpha70);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0106);
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.j.setAlpha(0.4f);
                this.p.setBackgroundColor(this.f25243b.getResources().getColor(R.color.black_alpha60));
                return;
            }
            this.j.setAlpha(1.0f);
            this.p.setBackgroundColor(this.f25243b.getResources().getColor(R.color.black_alpha30));
        }
    }

    public void g(AlaUserInfoData alaUserInfoData, List<b.a.r0.w.l.g.c.b.c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, alaUserInfoData, list) == null) {
            b.a.r0.w.l.g.c.a aVar = this.f25245d;
            if (aVar != null && list != null) {
                aVar.d(list);
            }
            i(alaUserInfoData);
        }
    }

    public void h(int i2, int i3, boolean z, View.OnClickListener onClickListener) {
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), onClickListener}) == null) || (tbPageContext = this.f25243b) == null) {
            return;
        }
        if (this.m == null) {
            this.m = new AlaNetRefreshView(tbPageContext.getPageActivity());
        }
        this.m.setImageResource(i2);
        this.m.setNetFailTipText(this.f25243b.getString(i3));
        this.m.onChangeSkinType();
        this.m.setIsShowRefreshButton(z);
        if (z) {
            this.m.setOnRefreshClickListener(onClickListener);
        }
        this.m.attachView(this.n);
    }

    public final void i(AlaUserInfoData alaUserInfoData) {
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, alaUserInfoData) == null) {
            if (alaUserInfoData != null) {
                String str = alaUserInfoData.user_nickname;
                String str2 = alaUserInfoData.user_name;
                if (str == null) {
                    str = str2 != null ? str2 : TbadkCoreApplication.getCurrentAccountNameShow();
                }
                String str3 = alaUserInfoData.portrait;
                if (str3 == null) {
                    str3 = TbadkCoreApplication.getCurrentPortrait();
                }
                if (alaUserInfoData.mark_count == null) {
                    format = String.format(this.f25243b.getString(R.string.ala_achievement_mark_get_text), 0);
                } else {
                    format = String.format(this.f25243b.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
                }
                j(str3, str, format);
                int dimension = (int) this.f25243b.getResources().getDimension(R.dimen.ds32);
                List<AlaLiveMarkData> list = this.r;
                if (list != null && list.size() > 0) {
                    this.r.clear();
                }
                LinearLayout linearLayout = this.l;
                if (linearLayout != null) {
                    linearLayout.removeAllViews();
                    List<AlaLiveMarkData> list2 = alaUserInfoData.live_mark_info_new;
                    this.r = list2;
                    if (list2 != null) {
                        for (int i2 = 0; i2 < this.r.size(); i2++) {
                            TbImageView tbImageView = new TbImageView(this.f25243b.getPageActivity());
                            tbImageView.setDefaultBgResource(R.color.transparent);
                            tbImageView.startLoad(this.r.get(i2).mark_pic, 21, false);
                            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.f25243b.getResources().getDimension(R.dimen.ds12);
                            this.l.addView(tbImageView);
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            j(TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountNameShow(), String.format(this.f25243b.getString(R.string.ala_achievement_mark_get_text), 0));
            List<AlaLiveMarkData> list3 = this.r;
            if (list3 != null && list3.size() > 0) {
                this.r.clear();
            }
            LinearLayout linearLayout2 = this.l;
            if (linearLayout2 != null) {
                linearLayout2.removeAllViews();
            }
        }
    }

    public final void j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            if (!StringUtils.isNull(str)) {
                this.f25246e.startLoad(str, 25, false);
                d.h().m(str, 25, new C1232a(this), null);
            } else {
                this.f25246e.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
                this.f25249h.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            }
            if (!StringUtils.isNull(str2)) {
                this.f25247f.setText(str2);
            } else {
                this.f25247f.setText("");
            }
            if (!StringUtils.isNull(str3)) {
                this.f25248g.setText(str3);
            } else {
                this.f25248g.setText("");
            }
        }
    }
}

package c.a.p0.z0.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.p0.z0.b.g;
import c.a.p0.z0.c.a;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f28935e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1350a> f28936f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f28937g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28938h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f28939i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f28940j;
    public int k;
    public View.OnClickListener l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28941e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28941e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    this.f28941e.f28937g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f28941e.f28937g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: c.a.p0.z0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1351b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f28942a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f28943b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f28944c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f28945d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f28946e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f28947f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f28948g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f28949h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f28950i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f28951j;
        public TextView k;

        public C1351b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1351b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {myGiftListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28935e = 1;
        this.f28938h = false;
        this.k = -1;
        this.l = new a(this);
        this.f28937g = myGiftListActivity;
        this.f28940j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f28937g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f28937g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f28937g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f28937g.getResources().getString(R.string.send_gift), this.f28937g.getSendGiftClickListener()));
            this.f28937g.getResources().getDimension(R.dimen.tbds200);
            this.f28937g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f28937g.getUserSex();
            this.f28937g.getPageContext().getString(R.string.no_gift);
            String string = this.f28937g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f28937g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f28937g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.f28940j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.f28940j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f28939i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f28937g.getLayoutMode().k(skinType == 1);
            this.f28937g.getLayoutMode().j(inflate);
            this.f28939i.onChangeSkinType(this.f28937g.getPageContext(), skinType);
            this.f28939i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1350a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f28938h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C1350a> list = this.f28936f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f28936f.size()) {
                return null;
            }
            return this.f28936f.get(itemId);
        }
        return (a.C1350a) invokeI.objValue;
    }

    public void e(List<a.C1350a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f28938h = false;
            } else {
                this.f28938h = true;
            }
            this.f28936f = list;
            this.k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f28938h) {
                return 1;
            }
            List<a.C1350a> list = this.f28936f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f28936f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1351b c1351b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f28938h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c1351b = (C1351b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f28937g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c1351b = new C1351b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c1351b.f28942a = tbImageView;
                tbImageView.setRadius(l.e(this.f28937g.getBaseContext(), 25.0f));
                c1351b.f28943b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1351b.f28944c = headImageView;
                headImageView.setRadius(l.e(this.f28937g.getBaseContext(), 50.0f));
                c1351b.f28944c.setOnClickListener(this.l);
                c1351b.f28944c.setPlaceHolder(1);
                c1351b.f28945d = (TextView) view.findViewById(R.id.user_name);
                c1351b.f28949h = (TextView) view.findViewById(R.id.gift_num);
                c1351b.f28948g = (TextView) view.findViewById(R.id.gift_value_text);
                c1351b.f28947f = (TextView) view.findViewById(R.id.gift_name);
                c1351b.f28946e = (TextView) view.findViewById(R.id.time);
                c1351b.f28950i = (TextView) view.findViewById(R.id.paly_icon);
                c1351b.f28951j = (TextView) view.findViewById(R.id.reward_prefix);
                c1351b.k = (TextView) view.findViewById(R.id.reward_num);
                view.setTag(R.id.tag_first, c1351b);
            }
            if (!this.f28940j) {
                c1351b.f28946e.setVisibility(8);
                c1351b.f28950i.setVisibility(8);
            } else {
                c1351b.f28950i.setVisibility(0);
            }
            a.C1350a item = getItem(i2);
            if (item != null) {
                if (this.f28937g.userType == 1) {
                    c1351b.f28944c.startLoad(item.f28922c, 12, false);
                    int i3 = item.f28929j;
                    if (i3 == 1) {
                        c1351b.f28942a.setVisibility(0);
                        c1351b.f28942a.setImageResource(R.drawable.icon_frs_no1);
                        c1351b.f28943b.setVisibility(8);
                    } else if (i3 == 2) {
                        c1351b.f28942a.setVisibility(0);
                        c1351b.f28942a.setImageResource(R.drawable.icon_frs_no2);
                        c1351b.f28943b.setVisibility(8);
                    } else if (i3 == 3) {
                        c1351b.f28942a.setVisibility(0);
                        c1351b.f28942a.setImageResource(R.drawable.icon_frs_no3);
                        c1351b.f28943b.setVisibility(8);
                    } else {
                        c1351b.f28942a.setVisibility(8);
                        c1351b.f28943b.setVisibility(0);
                        TextView textView = c1351b.f28943b;
                        textView.setText(item.f28929j + "");
                    }
                } else {
                    c1351b.f28944c.startLoad(item.f28923d, 10, false);
                    c1351b.f28942a.setVisibility(8);
                    c1351b.f28943b.setVisibility(8);
                }
                c1351b.f28944c.setDrawBorder(false);
                c1351b.f28945d.setText(TextUtils.isEmpty(item.k) ? item.f28921b : item.k);
                c1351b.f28944c.setTag(R.id.tag_first, Long.valueOf(item.f28920a));
                c1351b.f28944c.setTag(R.id.tag_second, item.f28921b);
                c1351b.f28947f.setText(this.f28937g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c1351b.f28948g;
                textView2.setText(this.f28937g.getPageContext().getString(R.string.gift_value) + item.f28926g);
                if (item.f28925f < 1) {
                    c1351b.f28949h.setVisibility(8);
                } else {
                    TextView textView3 = c1351b.f28949h;
                    textView3.setText(this.f28937g.getPageContext().getString(R.string.mutil_sign) + item.f28925f);
                    c1351b.f28949h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f28924e * 1000);
                c1351b.f28946e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                    c1351b.f28946e.setVisibility(8);
                    c1351b.f28948g.setText(formatTime);
                    SkinManager.setViewTextColor(c1351b.f28948g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c1351b.f28948g, R.color.CAM_X0301, 1);
                }
                c1351b.f28951j.setVisibility(0);
                c1351b.k.setVisibility(0);
                if (item.f28927h > 0) {
                    if (Integer.parseInt(item.f28928i) == 1) {
                        c1351b.k.setText(g.a(item.f28927h, 1, this.k));
                    } else if (Integer.parseInt(item.f28928i) == 2) {
                        c1351b.k.setText(g.a(item.f28927h, 2, this.k));
                    } else {
                        c1351b.f28951j.setVisibility(8);
                        c1351b.k.setVisibility(8);
                    }
                } else {
                    c1351b.f28951j.setVisibility(8);
                    c1351b.k.setVisibility(8);
                }
            }
            b(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28935e : invokeV.intValue;
    }
}

package c.a.u0.i1.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.u0.i1.c.a;
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
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f18733e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1153a> f18734f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f18735g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18736h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f18737i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18738j;
    public int k;
    public View.OnClickListener l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18739e;

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
            this.f18739e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    this.f18739e.f18735g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f18739e.f18735g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: c.a.u0.i1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1154b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18740b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f18741c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18742d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18743e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f18744f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18745g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18746h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f18747i;

        public C1154b() {
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

        public /* synthetic */ C1154b(a aVar) {
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
        this.f18733e = 1;
        this.f18736h = false;
        this.k = -1;
        this.l = new a(this);
        this.f18735g = myGiftListActivity;
        this.f18738j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f18735g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f18735g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f18735g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f18735g.getResources().getString(R.string.send_gift), this.f18735g.getSendGiftClickListener()));
            this.f18735g.getResources().getDimension(R.dimen.tbds200);
            this.f18735g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f18735g.getUserSex();
            this.f18735g.getPageContext().getString(R.string.no_gift);
            String string = this.f18735g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f18735g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f18735g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.f18738j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.f18738j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f18737i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f18735g.getLayoutMode().k(skinType == 1);
            this.f18735g.getLayoutMode().j(inflate);
            this.f18737i.onChangeSkinType(this.f18735g.getPageContext(), skinType);
            this.f18737i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1153a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f18736h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C1153a> list = this.f18734f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f18734f.size()) {
                return null;
            }
            return this.f18734f.get(itemId);
        }
        return (a.C1153a) invokeI.objValue;
    }

    public void e(List<a.C1153a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f18736h = false;
            } else {
                this.f18736h = true;
            }
            this.f18734f = list;
            this.k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f18736h) {
                return 1;
            }
            List<a.C1153a> list = this.f18734f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f18734f.size();
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
        C1154b c1154b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f18736h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c1154b = (C1154b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f18735g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c1154b = new C1154b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c1154b.a = tbImageView;
                tbImageView.setRadius(n.d(this.f18735g.getBaseContext(), 25.0f));
                c1154b.f18740b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1154b.f18741c = headImageView;
                headImageView.setRadius(n.d(this.f18735g.getBaseContext(), 50.0f));
                c1154b.f18741c.setOnClickListener(this.l);
                c1154b.f18741c.setPlaceHolder(1);
                c1154b.f18742d = (TextView) view.findViewById(R.id.user_name);
                c1154b.f18746h = (TextView) view.findViewById(R.id.gift_num);
                c1154b.f18745g = (TextView) view.findViewById(R.id.gift_value_text);
                c1154b.f18744f = (TextView) view.findViewById(R.id.gift_name);
                c1154b.f18743e = (TextView) view.findViewById(R.id.time);
                c1154b.f18747i = (TextView) view.findViewById(R.id.paly_icon);
                view.setTag(R.id.tag_first, c1154b);
            }
            if (!this.f18738j) {
                c1154b.f18743e.setVisibility(8);
                c1154b.f18747i.setVisibility(8);
            } else {
                c1154b.f18747i.setVisibility(0);
            }
            a.C1153a item = getItem(i2);
            if (item != null) {
                if (this.f18735g.userType == 1) {
                    c1154b.f18741c.startLoad(item.f18723c, 12, false);
                    int i3 = item.f18728h;
                    if (i3 == 1) {
                        c1154b.a.setVisibility(0);
                        c1154b.a.setImageResource(R.drawable.icon_frs_no1);
                        c1154b.f18740b.setVisibility(8);
                    } else if (i3 == 2) {
                        c1154b.a.setVisibility(0);
                        c1154b.a.setImageResource(R.drawable.icon_frs_no2);
                        c1154b.f18740b.setVisibility(8);
                    } else if (i3 == 3) {
                        c1154b.a.setVisibility(0);
                        c1154b.a.setImageResource(R.drawable.icon_frs_no3);
                        c1154b.f18740b.setVisibility(8);
                    } else {
                        c1154b.a.setVisibility(8);
                        c1154b.f18740b.setVisibility(0);
                        TextView textView = c1154b.f18740b;
                        textView.setText(item.f18728h + "");
                    }
                } else {
                    c1154b.f18741c.startLoad(item.f18724d, 10, false);
                    c1154b.a.setVisibility(8);
                    c1154b.f18740b.setVisibility(8);
                }
                c1154b.f18741c.setDrawBorder(false);
                c1154b.f18742d.setText(TextUtils.isEmpty(item.f18729i) ? item.f18722b : item.f18729i);
                c1154b.f18741c.setTag(R.id.tag_first, Long.valueOf(item.a));
                c1154b.f18741c.setTag(R.id.tag_second, item.f18722b);
                c1154b.f18744f.setText(this.f18735g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c1154b.f18745g;
                textView2.setText(this.f18735g.getPageContext().getString(R.string.gift_value) + item.f18727g);
                if (item.f18726f < 1) {
                    c1154b.f18746h.setVisibility(8);
                } else {
                    TextView textView3 = c1154b.f18746h;
                    textView3.setText(this.f18735g.getPageContext().getString(R.string.mutil_sign) + item.f18726f);
                    c1154b.f18746h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f18725e * 1000);
                c1154b.f18743e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                    c1154b.f18743e.setVisibility(8);
                    c1154b.f18745g.setText(formatTime);
                    SkinManager.setViewTextColor(c1154b.f18745g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c1154b.f18745g, R.color.CAM_X0301, 1);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f18733e : invokeV.intValue;
    }
}

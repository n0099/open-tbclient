package c.a.r0.h1.c;

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
import c.a.r0.h1.c.a;
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
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f17635e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1117a> f17636f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f17637g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17638h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f17639i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f17640j;
    public int k;
    public View.OnClickListener l;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17641e;

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
            this.f17641e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    this.f17641e.f17637g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f17641e.f17637g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: c.a.r0.h1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1118b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17642b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f17643c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17644d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17645e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17646f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17647g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f17648h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f17649i;

        public C1118b() {
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

        public /* synthetic */ C1118b(a aVar) {
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
        this.f17635e = 1;
        this.f17638h = false;
        this.k = -1;
        this.l = new a(this);
        this.f17637g = myGiftListActivity;
        this.f17640j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f17637g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f17637g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f17637g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f17637g.getResources().getString(R.string.send_gift), this.f17637g.getSendGiftClickListener()));
            this.f17637g.getResources().getDimension(R.dimen.tbds200);
            this.f17637g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f17637g.getUserSex();
            this.f17637g.getPageContext().getString(R.string.no_gift);
            String string = this.f17637g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f17637g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f17637g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.f17640j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.f17640j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f17639i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f17637g.getLayoutMode().k(skinType == 1);
            this.f17637g.getLayoutMode().j(inflate);
            this.f17639i.onChangeSkinType(this.f17637g.getPageContext(), skinType);
            this.f17639i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1117a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f17638h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C1117a> list = this.f17636f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f17636f.size()) {
                return null;
            }
            return this.f17636f.get(itemId);
        }
        return (a.C1117a) invokeI.objValue;
    }

    public void e(List<a.C1117a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f17638h = false;
            } else {
                this.f17638h = true;
            }
            this.f17636f = list;
            this.k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f17638h) {
                return 1;
            }
            List<a.C1117a> list = this.f17636f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f17636f.size();
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
        C1118b c1118b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f17638h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c1118b = (C1118b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f17637g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c1118b = new C1118b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c1118b.a = tbImageView;
                tbImageView.setRadius(n.d(this.f17637g.getBaseContext(), 25.0f));
                c1118b.f17642b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1118b.f17643c = headImageView;
                headImageView.setRadius(n.d(this.f17637g.getBaseContext(), 50.0f));
                c1118b.f17643c.setOnClickListener(this.l);
                c1118b.f17643c.setPlaceHolder(1);
                c1118b.f17644d = (TextView) view.findViewById(R.id.user_name);
                c1118b.f17648h = (TextView) view.findViewById(R.id.gift_num);
                c1118b.f17647g = (TextView) view.findViewById(R.id.gift_value_text);
                c1118b.f17646f = (TextView) view.findViewById(R.id.gift_name);
                c1118b.f17645e = (TextView) view.findViewById(R.id.time);
                c1118b.f17649i = (TextView) view.findViewById(R.id.paly_icon);
                view.setTag(R.id.tag_first, c1118b);
            }
            if (!this.f17640j) {
                c1118b.f17645e.setVisibility(8);
                c1118b.f17649i.setVisibility(8);
            } else {
                c1118b.f17649i.setVisibility(0);
            }
            a.C1117a item = getItem(i2);
            if (item != null) {
                if (this.f17637g.userType == 1) {
                    c1118b.f17643c.startLoad(item.f17625c, 12, false);
                    int i3 = item.f17630h;
                    if (i3 == 1) {
                        c1118b.a.setVisibility(0);
                        c1118b.a.setImageResource(R.drawable.icon_frs_no1);
                        c1118b.f17642b.setVisibility(8);
                    } else if (i3 == 2) {
                        c1118b.a.setVisibility(0);
                        c1118b.a.setImageResource(R.drawable.icon_frs_no2);
                        c1118b.f17642b.setVisibility(8);
                    } else if (i3 == 3) {
                        c1118b.a.setVisibility(0);
                        c1118b.a.setImageResource(R.drawable.icon_frs_no3);
                        c1118b.f17642b.setVisibility(8);
                    } else {
                        c1118b.a.setVisibility(8);
                        c1118b.f17642b.setVisibility(0);
                        TextView textView = c1118b.f17642b;
                        textView.setText(item.f17630h + "");
                    }
                } else {
                    c1118b.f17643c.startLoad(item.f17626d, 10, false);
                    c1118b.a.setVisibility(8);
                    c1118b.f17642b.setVisibility(8);
                }
                c1118b.f17643c.setDrawBorder(false);
                c1118b.f17644d.setText(TextUtils.isEmpty(item.f17631i) ? item.f17624b : item.f17631i);
                c1118b.f17643c.setTag(R.id.tag_first, Long.valueOf(item.a));
                c1118b.f17643c.setTag(R.id.tag_second, item.f17624b);
                c1118b.f17646f.setText(this.f17637g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c1118b.f17647g;
                textView2.setText(this.f17637g.getPageContext().getString(R.string.gift_value) + item.f17629g);
                if (item.f17628f < 1) {
                    c1118b.f17648h.setVisibility(8);
                } else {
                    TextView textView3 = c1118b.f17648h;
                    textView3.setText(this.f17637g.getPageContext().getString(R.string.mutil_sign) + item.f17628f);
                    c1118b.f17648h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f17627e * 1000);
                c1118b.f17645e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                    c1118b.f17645e.setVisibility(8);
                    c1118b.f17647g.setText(formatTime);
                    SkinManager.setViewTextColor(c1118b.f17647g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c1118b.f17647g, R.color.CAM_X0301, 1);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f17635e : invokeV.intValue;
    }
}

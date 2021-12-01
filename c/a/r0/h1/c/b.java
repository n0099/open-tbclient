package c.a.r0.h1.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.r0.h1.b.g;
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
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f17552e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1041a> f17553f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f17554g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17555h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f17556i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f17557j;

    /* renamed from: k  reason: collision with root package name */
    public int f17558k;
    public View.OnClickListener l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17559e;

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
            this.f17559e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    this.f17559e.f17554g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f17559e.f17554g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: c.a.r0.h1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1042b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17560b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f17561c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17562d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17563e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17564f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17565g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f17566h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f17567i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f17568j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f17569k;

        public C1042b() {
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

        public /* synthetic */ C1042b(a aVar) {
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
        this.f17552e = 1;
        this.f17555h = false;
        this.f17558k = -1;
        this.l = new a(this);
        this.f17554g = myGiftListActivity;
        this.f17557j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f17554g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f17554g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f17554g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f17554g.getResources().getString(R.string.send_gift), this.f17554g.getSendGiftClickListener()));
            this.f17554g.getResources().getDimension(R.dimen.tbds200);
            this.f17554g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f17554g.getUserSex();
            this.f17554g.getPageContext().getString(R.string.no_gift);
            String string = this.f17554g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f17554g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f17554g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.f17557j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.f17557j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f17556i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f17554g.getLayoutMode().k(skinType == 1);
            this.f17554g.getLayoutMode().j(inflate);
            this.f17556i.onChangeSkinType(this.f17554g.getPageContext(), skinType);
            this.f17556i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1041a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f17555h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C1041a> list = this.f17553f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f17553f.size()) {
                return null;
            }
            return this.f17553f.get(itemId);
        }
        return (a.C1041a) invokeI.objValue;
    }

    public void e(List<a.C1041a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f17555h = false;
            } else {
                this.f17555h = true;
            }
            this.f17553f = list;
            this.f17558k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f17555h) {
                return 1;
            }
            List<a.C1041a> list = this.f17553f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f17553f.size();
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
        C1042b c1042b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f17555h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c1042b = (C1042b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f17554g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c1042b = new C1042b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c1042b.a = tbImageView;
                tbImageView.setRadius(l.d(this.f17554g.getBaseContext(), 25.0f));
                c1042b.f17560b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1042b.f17561c = headImageView;
                headImageView.setRadius(l.d(this.f17554g.getBaseContext(), 50.0f));
                c1042b.f17561c.setOnClickListener(this.l);
                c1042b.f17561c.setPlaceHolder(1);
                c1042b.f17562d = (TextView) view.findViewById(R.id.user_name);
                c1042b.f17566h = (TextView) view.findViewById(R.id.gift_num);
                c1042b.f17565g = (TextView) view.findViewById(R.id.gift_value_text);
                c1042b.f17564f = (TextView) view.findViewById(R.id.gift_name);
                c1042b.f17563e = (TextView) view.findViewById(R.id.time);
                c1042b.f17567i = (TextView) view.findViewById(R.id.paly_icon);
                c1042b.f17568j = (TextView) view.findViewById(R.id.reward_prefix);
                c1042b.f17569k = (TextView) view.findViewById(R.id.reward_num);
                view.setTag(R.id.tag_first, c1042b);
            }
            if (!this.f17557j) {
                c1042b.f17563e.setVisibility(8);
                c1042b.f17567i.setVisibility(8);
            } else {
                c1042b.f17567i.setVisibility(0);
            }
            a.C1041a item = getItem(i2);
            if (item != null) {
                if (this.f17554g.userType == 1) {
                    c1042b.f17561c.startLoad(item.f17540c, 12, false);
                    int i3 = item.f17547j;
                    if (i3 == 1) {
                        c1042b.a.setVisibility(0);
                        c1042b.a.setImageResource(R.drawable.icon_frs_no1);
                        c1042b.f17560b.setVisibility(8);
                    } else if (i3 == 2) {
                        c1042b.a.setVisibility(0);
                        c1042b.a.setImageResource(R.drawable.icon_frs_no2);
                        c1042b.f17560b.setVisibility(8);
                    } else if (i3 == 3) {
                        c1042b.a.setVisibility(0);
                        c1042b.a.setImageResource(R.drawable.icon_frs_no3);
                        c1042b.f17560b.setVisibility(8);
                    } else {
                        c1042b.a.setVisibility(8);
                        c1042b.f17560b.setVisibility(0);
                        TextView textView = c1042b.f17560b;
                        textView.setText(item.f17547j + "");
                    }
                } else {
                    c1042b.f17561c.startLoad(item.f17541d, 10, false);
                    c1042b.a.setVisibility(8);
                    c1042b.f17560b.setVisibility(8);
                }
                c1042b.f17561c.setDrawBorder(false);
                c1042b.f17562d.setText(TextUtils.isEmpty(item.f17548k) ? item.f17539b : item.f17548k);
                c1042b.f17561c.setTag(R.id.tag_first, Long.valueOf(item.a));
                c1042b.f17561c.setTag(R.id.tag_second, item.f17539b);
                c1042b.f17564f.setText(this.f17554g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c1042b.f17565g;
                textView2.setText(this.f17554g.getPageContext().getString(R.string.gift_value) + item.f17544g);
                if (item.f17543f < 1) {
                    c1042b.f17566h.setVisibility(8);
                } else {
                    TextView textView3 = c1042b.f17566h;
                    textView3.setText(this.f17554g.getPageContext().getString(R.string.mutil_sign) + item.f17543f);
                    c1042b.f17566h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f17542e * 1000);
                c1042b.f17563e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.f17558k)) {
                    c1042b.f17563e.setVisibility(8);
                    c1042b.f17565g.setText(formatTime);
                    SkinManager.setViewTextColor(c1042b.f17565g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c1042b.f17565g, R.color.CAM_X0301, 1);
                }
                c1042b.f17568j.setVisibility(0);
                c1042b.f17569k.setVisibility(0);
                if (item.f17545h > 0) {
                    if (Integer.parseInt(item.f17546i) == 1) {
                        c1042b.f17569k.setText(g.a(item.f17545h, 1, this.f17558k));
                    } else if (Integer.parseInt(item.f17546i) == 2) {
                        c1042b.f17569k.setText(g.a(item.f17545h, 2, this.f17558k));
                    } else {
                        c1042b.f17568j.setVisibility(8);
                        c1042b.f17569k.setVisibility(8);
                    }
                } else {
                    c1042b.f17568j.setVisibility(8);
                    c1042b.f17569k.setVisibility(8);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f17552e : invokeV.intValue;
    }
}

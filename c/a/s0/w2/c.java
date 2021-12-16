package c.a.s0.w2;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.personExtra.PersonBarActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonBarActivity f25241e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.w2.b f25242f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ForumData> f25243g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25244h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f25245i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f25246j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f25247k;
    public boolean l;
    public boolean m;
    public View.OnClickListener n;
    public String o;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25248b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuffer f25249c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25250d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f25251e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f25252f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25253g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f25254h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f25255i;

        /* renamed from: j  reason: collision with root package name */
        public Button f25256j;

        /* renamed from: k  reason: collision with root package name */
        public ImageView f25257k;
        public ImageView l;
        public ImageView m;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(PersonBarActivity personBarActivity, c.a.s0.w2.b bVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personBarActivity, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25242f = null;
        this.f25243g = null;
        this.f25244h = false;
        this.f25245i = null;
        this.f25246j = false;
        this.f25247k = true;
        this.l = false;
        this.m = true;
        this.f25241e = personBarActivity;
        this.f25242f = bVar;
        this.f25247k = z;
        this.l = z2;
        this.m = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f25241e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f25241e.getLayoutMode().j(view);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25246j = false;
            ArrayList<ForumData> arrayList = this.f25243g;
            if (arrayList == null || arrayList.size() == 0) {
                this.f25246j = true;
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25244h : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25246j : invokeV.booleanValue;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f25245i = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f25244h = z;
            notifyDataSetChanged();
        }
    }

    public void g(ArrayList<ForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f25243g = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f25246j) {
                return 1;
            }
            ArrayList<ForumData> arrayList = this.f25243g;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ArrayList<ForumData> arrayList = this.f25243g;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f25243g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        ForumData forumData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            try {
                if (view == null) {
                    view = LayoutInflater.from(this.f25241e.getPageContext().getContext()).inflate(c.a.s0.y2.e.edit_bar_item, (ViewGroup) null);
                    bVar = new b(this, null);
                    BarImageView barImageView = (BarImageView) view.findViewById(c.a.s0.y2.d.forum_avatar);
                    bVar.a = barImageView;
                    barImageView.setGifIconSupport(false);
                    bVar.a.setRadius(m.f(this.f25241e, c.a.s0.y2.b.tbds10));
                    bVar.a.setConrers(15);
                    bVar.a.setPlaceHolder(2);
                    bVar.f25248b = (TextView) view.findViewById(c.a.s0.y2.d.name);
                    bVar.f25249c = new StringBuffer(10);
                    bVar.f25250d = (TextView) view.findViewById(c.a.s0.y2.d.degree);
                    bVar.f25251e = (TextView) view.findViewById(c.a.s0.y2.d.degree_text);
                    bVar.f25255i = (TextView) view.findViewById(c.a.s0.y2.d.experience);
                    bVar.f25253g = (TextView) view.findViewById(c.a.s0.y2.d.experience_title);
                    bVar.f25256j = (Button) view.findViewById(c.a.s0.y2.d.item_delete);
                    bVar.f25252f = (ImageView) view.findViewById(c.a.s0.y2.d.degree_text_ta);
                    bVar.f25254h = (TextView) view.findViewById(c.a.s0.y2.d.intro_ta);
                    bVar.f25257k = (ImageView) view.findViewById(c.a.s0.y2.d.item_talk);
                    ImageView imageView = (ImageView) view.findViewById(c.a.s0.y2.d.diver_buttom_px);
                    bVar.l = imageView;
                    imageView.setVisibility(0);
                    bVar.m = (ImageView) view.findViewById(c.a.s0.y2.d.item_selected);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (this.f25246j) {
                    bVar.f25250d.setVisibility(8);
                    bVar.f25256j.setVisibility(8);
                    bVar.f25248b.setVisibility(8);
                    bVar.a.setVisibility(8);
                    bVar.f25251e.setVisibility(8);
                    bVar.f25255i.setVisibility(8);
                    bVar.f25253g.setVisibility(8);
                    bVar.f25252f.setVisibility(8);
                    bVar.f25254h.setVisibility(8);
                    bVar.f25257k.setVisibility(8);
                    bVar.l.setVisibility(8);
                } else {
                    bVar.f25248b.setVisibility(0);
                    bVar.a.setVisibility(0);
                    if (this.f25247k) {
                        bVar.f25250d.setVisibility(8);
                        bVar.f25251e.setVisibility(8);
                        bVar.f25255i.setVisibility(0);
                        bVar.f25253g.setVisibility(0);
                        bVar.f25252f.setVisibility(0);
                        bVar.f25254h.setVisibility(8);
                        bVar.l.setVisibility(0);
                    } else {
                        bVar.f25250d.setVisibility(8);
                        bVar.f25251e.setVisibility(8);
                        bVar.f25255i.setVisibility(8);
                        bVar.f25253g.setVisibility(8);
                        bVar.f25252f.setVisibility(0);
                        bVar.f25254h.setVisibility(0);
                        bVar.l.setVisibility(0);
                    }
                }
                if (this.f25243g != null && i2 >= 0 && i2 < this.f25243g.size() && (forumData = this.f25243g.get(i2)) != null) {
                    String image_url = forumData.getImage_url();
                    bVar.a.setTag(image_url);
                    bVar.a.setImageDrawable(null);
                    bVar.a.startLoad(image_url, 10, false);
                    bVar.f25249c.delete(0, bVar.f25249c.length());
                    bVar.f25249c.append(forumData.getName());
                    bVar.f25249c.append(this.f25241e.getPageContext().getString(c.a.s0.y2.g.forum));
                    bVar.f25248b.setText(bVar.f25249c);
                    if (this.f25247k) {
                        SkinManager.setImageResource(bVar.f25252f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f25255i.setText(String.format(this.f25241e.getPageContext().getString(c.a.s0.y2.g.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        bVar.f25256j.setOnClickListener(this.f25245i);
                        bVar.f25256j.setTag(Integer.valueOf(i2));
                        if (i2 < this.f25242f.k()) {
                            bVar.f25248b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(c.a.s0.y2.c.icon_v), (Drawable) null);
                            if (!this.l && this.m) {
                                bVar.f25257k.setVisibility(0);
                                bVar.f25257k.setTag(Integer.valueOf(i2));
                            }
                        } else {
                            bVar.f25248b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            bVar.f25257k.setVisibility(8);
                        }
                        bVar.f25257k.setOnClickListener(this.n);
                        bVar.m.setVisibility(8);
                        if (this.l && this.f25241e.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.o)) {
                            bVar.m.setVisibility(0);
                        }
                    } else {
                        if ((this.f25241e.getCurrentPageType() == 0 && i2 < this.f25242f.k()) || (this.f25241e.getCurrentPageType() == 1 && i2 < this.f25242f.g())) {
                            bVar.f25248b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(c.a.s0.y2.c.icon_v), (Drawable) null);
                        } else {
                            bVar.f25248b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.f25241e.getCurrentPageType() == 1) {
                            bVar.f25252f.setVisibility(8);
                        }
                        bVar.f25257k.setVisibility(8);
                        SkinManager.setImageResource(bVar.f25252f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f25254h.setText(forumData.getSlogan());
                    }
                    if (this.f25244h) {
                        bVar.f25256j.setVisibility(0);
                        bVar.f25257k.setVisibility(8);
                    } else {
                        bVar.f25256j.setVisibility(8);
                        if (i2 < this.f25242f.k() && this.f25247k && !this.l && this.m) {
                            bVar.f25257k.setVisibility(0);
                        } else {
                            bVar.f25257k.setVisibility(8);
                        }
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            a(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.o = str;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (this.f25246j) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}

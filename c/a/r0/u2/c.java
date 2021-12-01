package c.a.r0.u2;

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
import c.a.d.f.p.l;
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
/* loaded from: classes7.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonBarActivity f24497e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.u2.b f24498f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ForumData> f24499g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24500h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f24501i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f24502j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f24503k;
    public boolean l;
    public boolean m;
    public View.OnClickListener n;
    public String o;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f24504b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuffer f24505c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f24506d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f24507e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f24508f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f24509g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f24510h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f24511i;

        /* renamed from: j  reason: collision with root package name */
        public Button f24512j;

        /* renamed from: k  reason: collision with root package name */
        public ImageView f24513k;
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

    public c(PersonBarActivity personBarActivity, c.a.r0.u2.b bVar, boolean z, boolean z2) {
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
        this.f24498f = null;
        this.f24499g = null;
        this.f24500h = false;
        this.f24501i = null;
        this.f24502j = false;
        this.f24503k = true;
        this.l = false;
        this.m = true;
        this.f24497e = personBarActivity;
        this.f24498f = bVar;
        this.f24503k = z;
        this.l = z2;
        this.m = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f24497e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f24497e.getLayoutMode().j(view);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24502j = false;
            ArrayList<ForumData> arrayList = this.f24499g;
            if (arrayList == null || arrayList.size() == 0) {
                this.f24502j = true;
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24500h : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24502j : invokeV.booleanValue;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f24501i = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f24500h = z;
            notifyDataSetChanged();
        }
    }

    public void g(ArrayList<ForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f24499g = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f24502j) {
                return 1;
            }
            ArrayList<ForumData> arrayList = this.f24499g;
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
            ArrayList<ForumData> arrayList = this.f24499g;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f24499g.get(i2);
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
                    view = LayoutInflater.from(this.f24497e.getPageContext().getContext()).inflate(c.a.r0.w2.e.edit_bar_item, (ViewGroup) null);
                    bVar = new b(this, null);
                    BarImageView barImageView = (BarImageView) view.findViewById(c.a.r0.w2.d.forum_avatar);
                    bVar.a = barImageView;
                    barImageView.setGifIconSupport(false);
                    bVar.a.setRadius(l.f(this.f24497e, c.a.r0.w2.b.tbds10));
                    bVar.a.setConrers(15);
                    bVar.a.setPlaceHolder(2);
                    bVar.f24504b = (TextView) view.findViewById(c.a.r0.w2.d.name);
                    bVar.f24505c = new StringBuffer(10);
                    bVar.f24506d = (TextView) view.findViewById(c.a.r0.w2.d.degree);
                    bVar.f24507e = (TextView) view.findViewById(c.a.r0.w2.d.degree_text);
                    bVar.f24511i = (TextView) view.findViewById(c.a.r0.w2.d.experience);
                    bVar.f24509g = (TextView) view.findViewById(c.a.r0.w2.d.experience_title);
                    bVar.f24512j = (Button) view.findViewById(c.a.r0.w2.d.item_delete);
                    bVar.f24508f = (ImageView) view.findViewById(c.a.r0.w2.d.degree_text_ta);
                    bVar.f24510h = (TextView) view.findViewById(c.a.r0.w2.d.intro_ta);
                    bVar.f24513k = (ImageView) view.findViewById(c.a.r0.w2.d.item_talk);
                    ImageView imageView = (ImageView) view.findViewById(c.a.r0.w2.d.diver_buttom_px);
                    bVar.l = imageView;
                    imageView.setVisibility(0);
                    bVar.m = (ImageView) view.findViewById(c.a.r0.w2.d.item_selected);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (this.f24502j) {
                    bVar.f24506d.setVisibility(8);
                    bVar.f24512j.setVisibility(8);
                    bVar.f24504b.setVisibility(8);
                    bVar.a.setVisibility(8);
                    bVar.f24507e.setVisibility(8);
                    bVar.f24511i.setVisibility(8);
                    bVar.f24509g.setVisibility(8);
                    bVar.f24508f.setVisibility(8);
                    bVar.f24510h.setVisibility(8);
                    bVar.f24513k.setVisibility(8);
                    bVar.l.setVisibility(8);
                } else {
                    bVar.f24504b.setVisibility(0);
                    bVar.a.setVisibility(0);
                    if (this.f24503k) {
                        bVar.f24506d.setVisibility(8);
                        bVar.f24507e.setVisibility(8);
                        bVar.f24511i.setVisibility(0);
                        bVar.f24509g.setVisibility(0);
                        bVar.f24508f.setVisibility(0);
                        bVar.f24510h.setVisibility(8);
                        bVar.l.setVisibility(0);
                    } else {
                        bVar.f24506d.setVisibility(8);
                        bVar.f24507e.setVisibility(8);
                        bVar.f24511i.setVisibility(8);
                        bVar.f24509g.setVisibility(8);
                        bVar.f24508f.setVisibility(0);
                        bVar.f24510h.setVisibility(0);
                        bVar.l.setVisibility(0);
                    }
                }
                if (this.f24499g != null && i2 >= 0 && i2 < this.f24499g.size() && (forumData = this.f24499g.get(i2)) != null) {
                    String image_url = forumData.getImage_url();
                    bVar.a.setTag(image_url);
                    bVar.a.setImageDrawable(null);
                    bVar.a.startLoad(image_url, 10, false);
                    bVar.f24505c.delete(0, bVar.f24505c.length());
                    bVar.f24505c.append(forumData.getName());
                    bVar.f24505c.append(this.f24497e.getPageContext().getString(c.a.r0.w2.g.forum));
                    bVar.f24504b.setText(bVar.f24505c);
                    if (this.f24503k) {
                        SkinManager.setImageResource(bVar.f24508f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f24511i.setText(String.format(this.f24497e.getPageContext().getString(c.a.r0.w2.g.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        bVar.f24512j.setOnClickListener(this.f24501i);
                        bVar.f24512j.setTag(Integer.valueOf(i2));
                        if (i2 < this.f24498f.k()) {
                            bVar.f24504b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(c.a.r0.w2.c.icon_v), (Drawable) null);
                            if (!this.l && this.m) {
                                bVar.f24513k.setVisibility(0);
                                bVar.f24513k.setTag(Integer.valueOf(i2));
                            }
                        } else {
                            bVar.f24504b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            bVar.f24513k.setVisibility(8);
                        }
                        bVar.f24513k.setOnClickListener(this.n);
                        bVar.m.setVisibility(8);
                        if (this.l && this.f24497e.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.o)) {
                            bVar.m.setVisibility(0);
                        }
                    } else {
                        if ((this.f24497e.getCurrentPageType() == 0 && i2 < this.f24498f.k()) || (this.f24497e.getCurrentPageType() == 1 && i2 < this.f24498f.g())) {
                            bVar.f24504b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(c.a.r0.w2.c.icon_v), (Drawable) null);
                        } else {
                            bVar.f24504b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.f24497e.getCurrentPageType() == 1) {
                            bVar.f24508f.setVisibility(8);
                        }
                        bVar.f24513k.setVisibility(8);
                        SkinManager.setImageResource(bVar.f24508f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f24510h.setText(forumData.getSlogan());
                    }
                    if (this.f24500h) {
                        bVar.f24512j.setVisibility(0);
                        bVar.f24513k.setVisibility(8);
                    } else {
                        bVar.f24512j.setVisibility(8);
                        if (i2 < this.f24498f.k() && this.f24503k && !this.l && this.m) {
                            bVar.f24513k.setVisibility(0);
                        } else {
                            bVar.f24513k.setVisibility(8);
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
            if (this.f24502j) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}

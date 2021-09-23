package c.a.r0.n2;

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
import c.a.e.e.p.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.PersonBarActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonBarActivity f22968e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.n2.b f22969f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ForumData> f22970g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22971h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f22972i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f22973j;
    public boolean k;
    public boolean l;
    public boolean m;
    public View.OnClickListener n;
    public String o;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f22974a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f22975b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuffer f22976c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f22977d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f22978e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f22979f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f22980g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f22981h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f22982i;

        /* renamed from: j  reason: collision with root package name */
        public Button f22983j;
        public ImageView k;
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

    public c(PersonBarActivity personBarActivity, c.a.r0.n2.b bVar, boolean z, boolean z2) {
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
        this.f22969f = null;
        this.f22970g = null;
        this.f22971h = false;
        this.f22972i = null;
        this.f22973j = false;
        this.k = true;
        this.l = false;
        this.m = true;
        this.f22968e = personBarActivity;
        this.f22969f = bVar;
        this.k = z;
        this.l = z2;
        this.m = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f22968e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f22968e.getLayoutMode().j(view);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22973j = false;
            ArrayList<ForumData> arrayList = this.f22970g;
            if (arrayList == null || arrayList.size() == 0) {
                this.f22973j = true;
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22971h : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22973j : invokeV.booleanValue;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f22972i = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f22971h = z;
            notifyDataSetChanged();
        }
    }

    public void g(ArrayList<ForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f22970g = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f22973j) {
                return 1;
            }
            ArrayList<ForumData> arrayList = this.f22970g;
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
            ArrayList<ForumData> arrayList = this.f22970g;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f22970g.get(i2);
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
                    view = LayoutInflater.from(this.f22968e.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                    bVar = new b(this, null);
                    BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                    bVar.f22974a = barImageView;
                    barImageView.setGifIconSupport(false);
                    bVar.f22974a.setRadius(l.g(this.f22968e, R.dimen.tbds10));
                    bVar.f22974a.setConrers(15);
                    bVar.f22974a.setPlaceHolder(2);
                    bVar.f22975b = (TextView) view.findViewById(R.id.name);
                    bVar.f22976c = new StringBuffer(10);
                    bVar.f22977d = (TextView) view.findViewById(R.id.degree);
                    bVar.f22978e = (TextView) view.findViewById(R.id.degree_text);
                    bVar.f22982i = (TextView) view.findViewById(R.id.experience);
                    bVar.f22980g = (TextView) view.findViewById(R.id.experience_title);
                    bVar.f22983j = (Button) view.findViewById(R.id.item_delete);
                    bVar.f22979f = (ImageView) view.findViewById(R.id.degree_text_ta);
                    bVar.f22981h = (TextView) view.findViewById(R.id.intro_ta);
                    bVar.k = (ImageView) view.findViewById(R.id.item_talk);
                    ImageView imageView = (ImageView) view.findViewById(R.id.diver_buttom_px);
                    bVar.l = imageView;
                    imageView.setVisibility(0);
                    bVar.m = (ImageView) view.findViewById(R.id.item_selected);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (this.f22973j) {
                    bVar.f22977d.setVisibility(8);
                    bVar.f22983j.setVisibility(8);
                    bVar.f22975b.setVisibility(8);
                    bVar.f22974a.setVisibility(8);
                    bVar.f22978e.setVisibility(8);
                    bVar.f22982i.setVisibility(8);
                    bVar.f22980g.setVisibility(8);
                    bVar.f22979f.setVisibility(8);
                    bVar.f22981h.setVisibility(8);
                    bVar.k.setVisibility(8);
                    bVar.l.setVisibility(8);
                } else {
                    bVar.f22975b.setVisibility(0);
                    bVar.f22974a.setVisibility(0);
                    if (this.k) {
                        bVar.f22977d.setVisibility(8);
                        bVar.f22978e.setVisibility(8);
                        bVar.f22982i.setVisibility(0);
                        bVar.f22980g.setVisibility(0);
                        bVar.f22979f.setVisibility(0);
                        bVar.f22981h.setVisibility(8);
                        bVar.l.setVisibility(0);
                    } else {
                        bVar.f22977d.setVisibility(8);
                        bVar.f22978e.setVisibility(8);
                        bVar.f22982i.setVisibility(8);
                        bVar.f22980g.setVisibility(8);
                        bVar.f22979f.setVisibility(0);
                        bVar.f22981h.setVisibility(0);
                        bVar.l.setVisibility(0);
                    }
                }
                if (this.f22970g != null && i2 >= 0 && i2 < this.f22970g.size() && (forumData = this.f22970g.get(i2)) != null) {
                    String image_url = forumData.getImage_url();
                    bVar.f22974a.setTag(image_url);
                    bVar.f22974a.setImageDrawable(null);
                    bVar.f22974a.startLoad(image_url, 10, false);
                    bVar.f22976c.delete(0, bVar.f22976c.length());
                    bVar.f22976c.append(forumData.getName());
                    bVar.f22976c.append(this.f22968e.getPageContext().getString(R.string.forum));
                    bVar.f22975b.setText(bVar.f22976c);
                    if (this.k) {
                        SkinManager.setImageResource(bVar.f22979f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f22982i.setText(String.format(this.f22968e.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        bVar.f22983j.setOnClickListener(this.f22972i);
                        bVar.f22983j.setTag(Integer.valueOf(i2));
                        if (i2 < this.f22969f.k()) {
                            bVar.f22975b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                            if (!this.l && this.m) {
                                bVar.k.setVisibility(0);
                                bVar.k.setTag(Integer.valueOf(i2));
                            }
                        } else {
                            bVar.f22975b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            bVar.k.setVisibility(8);
                        }
                        bVar.k.setOnClickListener(this.n);
                        bVar.m.setVisibility(8);
                        if (this.l && this.f22968e.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.o)) {
                            bVar.m.setVisibility(0);
                        }
                    } else {
                        if ((this.f22968e.getCurrentPageType() == 0 && i2 < this.f22969f.k()) || (this.f22968e.getCurrentPageType() == 1 && i2 < this.f22969f.g())) {
                            bVar.f22975b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                        } else {
                            bVar.f22975b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.f22968e.getCurrentPageType() == 1) {
                            bVar.f22979f.setVisibility(8);
                        }
                        bVar.k.setVisibility(8);
                        SkinManager.setImageResource(bVar.f22979f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f22981h.setText(forumData.getSlogan());
                    }
                    if (this.f22971h) {
                        bVar.f22983j.setVisibility(0);
                        bVar.k.setVisibility(8);
                    } else {
                        bVar.f22983j.setVisibility(8);
                        if (i2 < this.f22969f.k() && this.k && !this.l && this.m) {
                            bVar.k.setVisibility(0);
                        } else {
                            bVar.k.setVisibility(8);
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
            if (this.f22973j) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}

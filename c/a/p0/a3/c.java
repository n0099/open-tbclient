package c.a.p0.a3;

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
import c.a.d.f.p.n;
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
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonBarActivity a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a3.b f12122b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ForumData> f12123c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12124d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f12125e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12126f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12127g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12128h;
    public boolean i;
    public View.OnClickListener j;
    public String k;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f12129b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuffer f12130c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f12131d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f12132e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f12133f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f12134g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f12135h;
        public TextView i;
        public Button j;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(PersonBarActivity personBarActivity, c.a.p0.a3.b bVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personBarActivity, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12122b = null;
        this.f12123c = null;
        this.f12124d = false;
        this.f12125e = null;
        this.f12126f = false;
        this.f12127g = true;
        this.f12128h = false;
        this.i = true;
        this.a = personBarActivity;
        this.f12122b = bVar;
        this.f12127g = z;
        this.f12128h = z2;
        this.i = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().j(view);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f12126f = false;
            ArrayList<ForumData> arrayList = this.f12123c;
            if (arrayList == null || arrayList.size() == 0) {
                this.f12126f = true;
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12124d : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12126f : invokeV.booleanValue;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f12125e = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f12124d = z;
            notifyDataSetChanged();
        }
    }

    public void g(ArrayList<ForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f12123c = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f12126f) {
                return 1;
            }
            ArrayList<ForumData> arrayList = this.f12123c;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            ArrayList<ForumData> arrayList = this.f12123c;
            if (arrayList == null || i < 0 || i >= arrayList.size()) {
                return null;
            }
            return this.f12123c.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        ForumData forumData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view, viewGroup)) == null) {
            try {
                if (view == null) {
                    view = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d024b, (ViewGroup) null);
                    bVar = new b(this, null);
                    BarImageView barImageView = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f090a1e);
                    bVar.a = barImageView;
                    barImageView.setGifIconSupport(false);
                    bVar.a.setRadius(n.f(this.a, R.dimen.tbds10));
                    bVar.a.setConrers(15);
                    bVar.a.setPlaceHolder(2);
                    bVar.f12129b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0914e9);
                    bVar.f12130c = new StringBuffer(10);
                    bVar.f12131d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090768);
                    bVar.f12132e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090769);
                    bVar.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09093b);
                    bVar.f12134g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090940);
                    bVar.j = (Button) view.findViewById(R.id.obfuscated_res_0x7f090f67);
                    bVar.f12133f = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09076a);
                    bVar.f12135h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f4b);
                    bVar.k = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090fa8);
                    ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0907d6);
                    bVar.l = imageView;
                    imageView.setVisibility(0);
                    bVar.m = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090f9f);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (this.f12126f) {
                    bVar.f12131d.setVisibility(8);
                    bVar.j.setVisibility(8);
                    bVar.f12129b.setVisibility(8);
                    bVar.a.setVisibility(8);
                    bVar.f12132e.setVisibility(8);
                    bVar.i.setVisibility(8);
                    bVar.f12134g.setVisibility(8);
                    bVar.f12133f.setVisibility(8);
                    bVar.f12135h.setVisibility(8);
                    bVar.k.setVisibility(8);
                    bVar.l.setVisibility(8);
                } else {
                    bVar.f12129b.setVisibility(0);
                    bVar.a.setVisibility(0);
                    if (this.f12127g) {
                        bVar.f12131d.setVisibility(8);
                        bVar.f12132e.setVisibility(8);
                        bVar.i.setVisibility(0);
                        bVar.f12134g.setVisibility(0);
                        bVar.f12133f.setVisibility(0);
                        bVar.f12135h.setVisibility(8);
                        bVar.l.setVisibility(0);
                    } else {
                        bVar.f12131d.setVisibility(8);
                        bVar.f12132e.setVisibility(8);
                        bVar.i.setVisibility(8);
                        bVar.f12134g.setVisibility(8);
                        bVar.f12133f.setVisibility(0);
                        bVar.f12135h.setVisibility(0);
                        bVar.l.setVisibility(0);
                    }
                }
                if (this.f12123c != null && i >= 0 && i < this.f12123c.size() && (forumData = this.f12123c.get(i)) != null) {
                    String image_url = forumData.getImage_url();
                    bVar.a.setTag(image_url);
                    bVar.a.setImageDrawable(null);
                    bVar.a.J(image_url, 10, false);
                    bVar.f12130c.delete(0, bVar.f12130c.length());
                    bVar.f12130c.append(forumData.getName());
                    bVar.f12130c.append(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f063c));
                    bVar.f12129b.setText(bVar.f12130c);
                    if (this.f12127g) {
                        SkinManager.setImageResource(bVar.f12133f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.i.setText(String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f115e), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        bVar.j.setOnClickListener(this.f12125e);
                        bVar.j.setTag(Integer.valueOf(i));
                        if (i < this.f12122b.k()) {
                            bVar.f12129b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                            if (!this.f12128h && this.i) {
                                bVar.k.setVisibility(0);
                                bVar.k.setTag(Integer.valueOf(i));
                            }
                        } else {
                            bVar.f12129b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            bVar.k.setVisibility(8);
                        }
                        bVar.k.setOnClickListener(this.j);
                        bVar.m.setVisibility(8);
                        if (this.f12128h && this.a.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.k)) {
                            bVar.m.setVisibility(0);
                        }
                    } else {
                        if ((this.a.getCurrentPageType() == 0 && i < this.f12122b.k()) || (this.a.getCurrentPageType() == 1 && i < this.f12122b.g())) {
                            bVar.f12129b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                        } else {
                            bVar.f12129b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.a.getCurrentPageType() == 1) {
                            bVar.f12133f.setVisibility(8);
                        }
                        bVar.k.setVisibility(8);
                        SkinManager.setImageResource(bVar.f12133f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f12135h.setText(forumData.getSlogan());
                    }
                    if (this.f12124d) {
                        bVar.j.setVisibility(0);
                        bVar.k.setVisibility(8);
                    } else {
                        bVar.j.setVisibility(8);
                        if (i < this.f12122b.k() && this.f12127g && !this.f12128h && this.i) {
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
            this.k = str;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            if (this.f12126f) {
                return false;
            }
            return super.isEnabled(i);
        }
        return invokeI.booleanValue;
    }
}

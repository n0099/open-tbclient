package c.a.r0.j2.k.e.b1.g;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionImageData> f19919e;

    /* renamed from: f  reason: collision with root package name */
    public int f19920f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f19921g;

    /* renamed from: h  reason: collision with root package name */
    public PbEmotionBar.i f19922h;

    /* renamed from: i  reason: collision with root package name */
    public Set<String> f19923i;

    /* renamed from: c.a.r0.j2.k.e.b1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0954a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19924e;

        public View$OnClickListenerC0954a(a aVar) {
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
            this.f19924e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f19924e.f19922h != null && (view instanceof EmotionView)) {
                EmotionView emotionView = (EmotionView) view;
                this.f19924e.f19922h.b(emotionView.getData(), emotionView.getIsGif());
                TiebaStatic.log("c12176");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19925e;

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
            this.f19925e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19925e.f19922h == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.f19925e.f19919e)) {
                for (EmotionImageData emotionImageData : this.f19925e.f19919e) {
                    if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        arrayList.add(emotionImageData.getThumbUrl());
                    }
                }
            }
            this.f19925e.f19922h.a(null, null, arrayList);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19926a;

        public c(a aVar) {
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
            this.f19926a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (this.f19926a.f19923i != null) {
                    for (String str : this.f19926a.f19923i) {
                        if (!TextUtils.isEmpty(str)) {
                            c.a.q0.c0.c.k().h(str);
                        }
                    }
                    return Boolean.TRUE;
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f19927a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19928b;

        public d() {
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
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19923i = new HashSet();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new c(this).execute(new Void[0]);
        }
    }

    public void e(List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f19919e = list;
        }
    }

    public void f(EmotionView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f19921g = cVar;
        }
    }

    public void g(PbEmotionBar.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f19922h = iVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f19919e)) {
                return 0;
            }
            return this.f19919e.size() + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                dVar = new d();
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
                EmotionView emotionView = (EmotionView) view2.findViewById(R.id.iv_emotion);
                dVar.f19927a = emotionView;
                emotionView.enablePreview();
                dVar.f19927a.setController(this.f19921g);
                dVar.f19927a.setOnClickListener(new View$OnClickListenerC0954a(this));
                TextView textView = (TextView) view2.findViewById(R.id.tv_more);
                dVar.f19928b = textView;
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                dVar.f19928b.setOnClickListener(new b(this));
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            if (i2 >= 0) {
                if (i2 < this.f19919e.size()) {
                    dVar.f19927a.getLayoutParams().width = this.f19920f;
                    dVar.f19927a.getLayoutParams().height = this.f19920f;
                    dVar.f19927a.reset();
                    dVar.f19927a.setTag(R.id.iv_emotion, null);
                    EmotionImageData emotionImageData = this.f19919e.get(i2);
                    if (emotionImageData != null) {
                        dVar.f19927a.loadData(emotionImageData);
                        if (this.f19923i != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                            Set<String> set = this.f19923i;
                            set.add(emotionImageData.getThumbUrl() + dVar.f19927a.getLoadProcType());
                        }
                    }
                    dVar.f19927a.setVisibility(0);
                    dVar.f19928b.setVisibility(8);
                } else if (i2 == this.f19919e.size()) {
                    dVar.f19928b.getLayoutParams().width = this.f19920f;
                    dVar.f19928b.getLayoutParams().height = this.f19920f;
                    dVar.f19927a.setVisibility(8);
                    dVar.f19928b.setVisibility(0);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f19920f == i2) {
            return;
        }
        this.f19920f = i2;
        notifyDataSetChanged();
    }
}

package c.a.q0.w3.i.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.q0.w3.i.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverPendantDragView;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends c.a.e.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f28339a;

    /* renamed from: b  reason: collision with root package name */
    public CoverSeekBar f28340b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f28341c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.w3.i.h.a f28342d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f28343e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.w3.i.c.a f28344f;

    /* renamed from: g  reason: collision with root package name */
    public CoverPendantDragView f28345g;

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f28346a;

        public a(c cVar) {
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
                    return;
                }
            }
            this.f28346a = cVar;
        }

        @Override // c.a.q0.w3.i.c.a.b
        public void a(View view, int i2, PendantData pendantData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, pendantData) == null) {
                this.f28346a.f28345g.changeEditState(view, pendantData);
                StatisticItem statisticItem = new StatisticItem("c12305");
                statisticItem.param("obj_locate", i2 + 1);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CoverSeekBar.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f28347a;

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
                    return;
                }
            }
            this.f28347a = cVar;
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log("c12304");
            }
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                int duration = (int) ((this.f28347a.f28342d.v().getDuration() * i2) / 1000);
                this.f28347a.f28340b.setProgressImage(i2, duration);
                this.f28347a.f28342d.v().seekTo(duration);
            }
        }
    }

    /* renamed from: c.a.q0.w3.i.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1321c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f28348e;

        public C1321c(c cVar) {
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
                    return;
                }
            }
            this.f28348e = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.f28348e.f28341c.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f28349e;

        public d(c cVar) {
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
                    return;
                }
            }
            this.f28349e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28349e.f28340b.seekTo(this.f28349e.f28340b.getCurrentPosition());
                this.f28349e.f28342d.B();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(f fVar, c.a.q0.w3.i.h.a aVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28342d = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.f28339a = inflate;
        inflate.getResources();
        m();
    }

    public Bitmap g(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            this.f28345g.hideSoftKeyPad();
            String text = this.f28345g.getText();
            if (bitmap == null || TextUtils.isEmpty(text)) {
                return null;
            }
            int width = this.f28342d.v().getWidth();
            int height = this.f28342d.v().getHeight();
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            Bitmap tempBitmap = this.f28345g.getTempBitmap();
            if (tempBitmap != null) {
                Matrix matrix = new Matrix();
                matrix.postScale(width2 / width, height2 / height);
                Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.f28342d.v().getLeft(), this.f28342d.v().getTop(), width, height, matrix, true);
                if (createBitmap2 != null) {
                    canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
                }
            }
            canvas.save();
            canvas.restore();
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28340b.getCurrentPosition() : invokeV.intValue;
    }

    public final List<PendantData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, new PendantData(0));
            arrayList.add(1, new PendantData(1));
            arrayList.add(2, new PendantData(2));
            arrayList.add(3, new PendantData(3));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28339a : (View) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28345g.getText() : (String) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f28345g.hideSoftKeyPad();
        }
    }

    public void l(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            CoverPendantDragView coverPendantDragView = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
            this.f28345g = coverPendantDragView;
            coverPendantDragView.setParentViewController(this);
            this.f28341c = (LinearLayout) view.findViewById(R.id.cover_tips);
            if (c.a.p0.s.d0.b.j().g("video_cover_first_in", true)) {
                this.f28341c.setVisibility(0);
                this.f28341c.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new C1321c(this)).start();
                c.a.p0.s.d0.b.j().t("video_cover_first_in", false);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f28340b = (CoverSeekBar) this.f28339a.findViewById(R.id.cover_seek_bar);
            this.f28343e = (HListView) this.f28339a.findViewById(R.id.pendant_list_view);
            c.a.q0.w3.i.c.a aVar = new c.a.q0.w3.i.c.a(getPageContext());
            this.f28344f = aVar;
            aVar.d(new a(this));
            this.f28343e.setAdapter((ListAdapter) this.f28344f);
            this.f28344f.c(h());
            this.f28340b.setOnProgressChanged(new b(this));
        }
    }

    public void n(f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, i2) == null) {
            SkinManager.setBackgroundColor(this.f28339a, R.color.CAM_X0201);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.e.e.m.e.a().postDelayed(new d(this), 500L);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f28345g.onSelectChange(z);
            if (z) {
                CoverSeekBar coverSeekBar = this.f28340b;
                coverSeekBar.seekTo(coverSeekBar.getCurrentPosition());
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            CoverSeekBar coverSeekBar = this.f28340b;
            if (coverSeekBar != null) {
                coverSeekBar.release();
            }
            CoverPendantDragView coverPendantDragView = this.f28345g;
            if (coverPendantDragView != null) {
                coverPendantDragView.onDestroy();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f28345g.setVideoSize(this.f28342d.v().getWidth(), this.f28342d.v().getHeight());
            this.f28345g.setVideoLocation(this.f28342d.v().getLeft(), this.f28342d.v().getTop(), this.f28342d.v().getRight(), this.f28342d.v().getBottom());
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f28340b.setData(str);
    }

    public void u(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.addAll(0, h());
            this.f28344f.c(list);
        }
    }
}

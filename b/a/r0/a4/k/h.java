package b.a.r0.a4.k;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.a4.k.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tieba.R;
import com.baidu.tieba.video.meida.MultiAudioMixer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.Container;
import com.facebook.imageutils.JfifUtil;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.googlecode.mp4parser.authoring.tracks.AACTrackImpl;
import com.googlecode.mp4parser.authoring.tracks.AppendTrack;
import com.googlecode.mp4parser.authoring.tracks.CroppedTrack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f16124a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements MultiAudioMixer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public FileOutputStream f16125a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f16126b;

        public a(h hVar, String str) throws FileNotFoundException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16126b = str;
            this.f16125a = new FileOutputStream(this.f16126b);
        }

        @Override // com.baidu.tieba.video.meida.MultiAudioMixer.c
        public void onMixComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f16125a != null) {
                        this.f16125a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.tieba.video.meida.MultiAudioMixer.c
        public void onMixError(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                try {
                    if (this.f16125a != null) {
                        this.f16125a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.tieba.video.meida.MultiAudioMixer.c
        public void onMixing(byte[] bArr) throws IOException {
            FileOutputStream fileOutputStream;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) || (fileOutputStream = this.f16125a) == null) {
                return;
            }
            fileOutputStream.write(bArr);
        }
    }

    public h() {
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
        g.g();
    }

    public static h e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f16124a == null) {
                synchronized (h.class) {
                    if (f16124a == null) {
                        f16124a = new h();
                    }
                }
            }
            return f16124a;
        }
        return (h) invokeV.objValue;
    }

    public final void a(long j, long j2, List<Track> list, List<Track> list2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list, list2}) == null) {
            Movie movie = new Movie();
            long j3 = 0;
            while (j > j3) {
                long j4 = j - j3;
                if (j4 >= j2) {
                    movie.addTrack(new AppendTrack((Track[]) list.toArray(new Track[list.size()])));
                    j3 += j2;
                } else {
                    double d2 = j4 / 1000;
                    double d3 = 0.0d;
                    boolean z = false;
                    for (Track track : list) {
                        if (track.getSyncSamples() != null && track.getSyncSamples().length > 0) {
                            if (!z) {
                                d3 = d(track, d3, false);
                                d2 = d(track, d2, true);
                                z = true;
                            } else {
                                throw new RuntimeException("The startTime has already been corrected by another track with SyncSample. Not Supported.");
                            }
                        }
                    }
                    for (Track track2 : list) {
                        long j5 = -1;
                        long j6 = -1;
                        int i2 = 0;
                        long j7 = 0;
                        double d4 = -1.0d;
                        double d5 = 0.0d;
                        while (i2 < track2.getSampleDurations().length) {
                            long j8 = j3;
                            long j9 = track2.getSampleDurations()[i2];
                            int i3 = (d5 > d4 ? 1 : (d5 == d4 ? 0 : -1));
                            if (i3 > 0 && d5 <= d3) {
                                j5 = j7;
                            }
                            if (i3 > 0 && d5 <= d2) {
                                j6 = j7;
                            }
                            j7++;
                            i2++;
                            d4 = d5;
                            d3 = d3;
                            d5 = (j9 / track2.getTrackMetaData().getTimescale()) + d5;
                            j3 = j8;
                        }
                        movie.addTrack(new CroppedTrack(track2, j5, j6));
                        d3 = d3;
                    }
                    j3 += j4;
                }
            }
            for (Track track3 : movie.getTracks()) {
                if (track3.getHandler().equals("soun")) {
                    list2.add(track3);
                }
            }
        }
    }

    public final long b(String str, List<Track> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list)) == null) {
            try {
                long j = 0;
                for (Track track : MovieCreator.build(str).getTracks()) {
                    if (track.getHandler().equals("soun")) {
                        list.add(track);
                        j += (track.getDuration() * 1000) / track.getTrackMetaData().getTimescale();
                    }
                }
                return j;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final e c(String str, List<Track> list, List<Track> list2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, list, list2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new e(-1L, 1, TbadkCoreApplication.getInst().getString(R.string.illegal_argument));
            }
            if (!new File(str).exists()) {
                return new e(-1L, 2, TbadkCoreApplication.getInst().getString(R.string.file_not_exist));
            }
            long j = 0;
            try {
                for (Track track : MovieCreator.build(str).getTracks()) {
                    if (list2 != null && track.getHandler().equals("soun")) {
                        list2.add(track);
                    }
                    if (track.getHandler().equals("vide")) {
                        list.add(track);
                        j += (track.getDuration() * 1000) / track.getTrackMetaData().getTimescale();
                    }
                }
                return new e(j, 0, "");
            } catch (Exception e2) {
                e2.printStackTrace();
                return new e(-1L, 3, b.a.r0.a2.a.a(e2));
            }
        }
        return (e) invokeLLL.objValue;
    }

    public final double d(Track track, double d2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{track, Double.valueOf(d2), Boolean.valueOf(z)})) == null) {
            int length = track.getSyncSamples().length;
            double[] dArr = new double[length];
            int i2 = 0;
            double d3 = 0.0d;
            long j = 0;
            double d4 = 0.0d;
            for (int i3 = 0; i3 < track.getSampleDurations().length; i3++) {
                long j2 = track.getSampleDurations()[i3];
                j++;
                if (Arrays.binarySearch(track.getSyncSamples(), j) >= 0) {
                    dArr[Arrays.binarySearch(track.getSyncSamples(), j)] = d4;
                }
                d4 += j2 / track.getTrackMetaData().getTimescale();
            }
            while (i2 < length) {
                double d5 = dArr[i2];
                if (d5 > d2) {
                    return z ? d5 : d3;
                }
                i2++;
                d3 = d5;
            }
            return dArr[length - 1];
        }
        return invokeCommon.doubleValue;
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public boolean f(String str, String str2, String... strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, strArr)) == null) {
            ?? r2 = 0;
            if (strArr != null) {
                int i2 = 2;
                if (strArr.length >= 2) {
                    String str3 = str2 + "temp_" + System.currentTimeMillis();
                    File[] fileArr = new File[strArr.length];
                    try {
                        g.a d2 = g.d(strArr[0]);
                        if (d2 == null) {
                            return false;
                        }
                        g.a aVar = new g.a();
                        char c2 = 1;
                        int i3 = 0;
                        boolean z = true;
                        while (i3 < strArr.length) {
                            if (i3 != 0) {
                                aVar = g.d(strArr[i3]);
                                if (aVar == null) {
                                    return r2;
                                }
                                g.a[] aVarArr = new g.a[i2];
                                aVarArr[r2] = d2;
                                aVarArr[c2] = aVar;
                                z = g.h(aVarArr);
                            }
                            String str4 = str2 + "temp_" + i3 + "_" + System.currentTimeMillis();
                            if (new b(strArr[i3]).a(str4, z, d2, aVar) != null) {
                                if (!z && i3 != 0 && aVar.c()) {
                                    String str5 = str2 + "resample_" + System.currentTimeMillis();
                                    long currentTimeMillis = System.currentTimeMillis();
                                    boolean i4 = g.i(str4, str5, aVar.f16120a, d2.f16120a);
                                    BdLog.e("resample cost = " + (System.currentTimeMillis() - currentTimeMillis));
                                    if (i4) {
                                        str4 = str5;
                                    }
                                }
                                fileArr[i3] = new File(str4);
                            }
                            i3++;
                            r2 = 0;
                            i2 = 2;
                            c2 = 1;
                        }
                        MultiAudioMixer a2 = MultiAudioMixer.a();
                        try {
                            a2.d(new a(this, str3));
                            a2.b(fileArr);
                            d a3 = d.a(str3);
                            a3.d(d2.f16120a);
                            a3.c(d2.f16121b);
                            a3.b(str);
                            return true;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return false;
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public i g(String str, String str2) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                long currentTimeMillis = System.currentTimeMillis();
                File file = new File(str2);
                file.mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                LinkedList linkedList = new LinkedList();
                try {
                    e c2 = c(str, linkedList, null);
                    if (c2.f16113a == -1) {
                        if (c2.f16114b == 1) {
                            i2 = 218;
                        } else {
                            i2 = c2.f16114b == 2 ? 219 : PassLivenessRecogActivity.S;
                        }
                        return new i(i2, c2.f16115c);
                    }
                    BdLog.e("mixingVideoByAudio videoTracks = " + linkedList.size());
                    j(str2, linkedList, null);
                    return new i(0, "");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new i(221, b.a.r0.a2.a.a(e2));
                } finally {
                    BdLog.e("mixingVideoByAudio cost = " + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
            return new i(217, TbadkCoreApplication.getInst().getString(R.string.illegal_argument));
        }
        return (i) invokeLL.objValue;
    }

    public i h(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        String str4;
        LinkedList linkedList;
        int i2;
        i iVar;
        StringBuilder sb;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) != null) {
            return (i) invokeCommon.objValue;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            long currentTimeMillis = System.currentTimeMillis();
            String str5 = b.a.r0.a4.c.f15921f + (TbMd5.getNameMd5FromUrl(str + str2 + str3) + "/");
            new File(str5).mkdirs();
            File file = new File(str3);
            file.mkdirs();
            if (file.exists()) {
                file.delete();
            }
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            LinkedList linkedList4 = new LinkedList();
            LinkedList linkedList5 = new LinkedList();
            try {
                e c2 = c(str, linkedList2, linkedList3);
                long j = c2.f16113a;
                if (j == -1) {
                    if (c2.f16114b == 1) {
                        i3 = 210;
                    } else {
                        i3 = c2.f16114b == 2 ? 211 : 212;
                    }
                    iVar = new i(i3, c2.f16115c);
                    FileHelper.deleteFileOrDir(new File(str5));
                    sb = new StringBuilder();
                } else {
                    long b2 = b(str2, linkedList4);
                    if (b2 == -1) {
                        if (c2.f16114b == 1) {
                            i2 = 213;
                        } else {
                            i2 = c2.f16114b == 2 ? 214 : JfifUtil.MARKER_RST7;
                        }
                        iVar = new i(i2, c2.f16115c);
                        FileHelper.deleteFileOrDir(new File(str5));
                        sb = new StringBuilder();
                    } else {
                        try {
                            a(j, b2, linkedList4, linkedList5);
                            if (!z || linkedList3.size() <= 0 || Build.VERSION.SDK_INT < 16) {
                                linkedList = linkedList3;
                            } else {
                                String str6 = str5 + "temp_" + System.currentTimeMillis();
                                j(str6, null, linkedList5);
                                String str7 = str5 + "temp_" + System.currentTimeMillis();
                                linkedList = linkedList3;
                                j(str7, null, linkedList);
                                String str8 = str5 + "temp_" + System.currentTimeMillis() + ".acc";
                                if (f(str8, str5, str6, str7)) {
                                    AACTrackImpl aACTrackImpl = new AACTrackImpl(new FileDataSourceImpl(str8));
                                    linkedList5.clear();
                                    linkedList5.add(aACTrackImpl);
                                }
                                BdLog.e("mixingVideoByAudio mixing cost = " + (System.currentTimeMillis() - currentTimeMillis));
                            }
                            BdLog.e("mixingVideoByAudio audioTracks = " + linkedList.size() + " musicTracks = " + linkedList5.size() + " videoTracks = " + linkedList2.size());
                            j(str3, linkedList2, linkedList5);
                            i iVar2 = new i(0, "");
                            FileHelper.deleteFileOrDir(new File(str5));
                            BdLog.e("mixingVideoByAudio cost = " + (System.currentTimeMillis() - currentTimeMillis));
                            return iVar2;
                        } catch (Exception e2) {
                            e = e2;
                            str4 = "mixingVideoByAudio cost = ";
                            try {
                                e.printStackTrace();
                                i iVar3 = new i(JfifUtil.MARKER_SOI, b.a.r0.a2.a.a(e));
                                FileHelper.deleteFileOrDir(new File(str5));
                                BdLog.e(str4 + (System.currentTimeMillis() - currentTimeMillis));
                                return iVar3;
                            } catch (Throwable th) {
                                th = th;
                                FileHelper.deleteFileOrDir(new File(str5));
                                BdLog.e(str4 + (System.currentTimeMillis() - currentTimeMillis));
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str4 = "mixingVideoByAudio cost = ";
                            FileHelper.deleteFileOrDir(new File(str5));
                            BdLog.e(str4 + (System.currentTimeMillis() - currentTimeMillis));
                            throw th;
                        }
                    }
                }
                sb.append("mixingVideoByAudio cost = ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                BdLog.e(sb.toString());
                return iVar;
            } catch (Exception e3) {
                e = e3;
                str4 = "mixingVideoByAudio cost = ";
            } catch (Throwable th3) {
                th = th3;
                str4 = "mixingVideoByAudio cost = ";
            }
        } else {
            return new i(209, TbadkCoreApplication.getInst().getString(R.string.illegal_argument));
        }
    }

    public i i(List<String> list, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, list, str, z)) == null) {
            if (list != null && !TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                File file = new File(str);
                file.mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    try {
                        e c2 = c(list.get(i2), linkedList, z ? linkedList2 : null);
                        if (c2.f16113a != -1) {
                            long j = c2.f16113a;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return new i(11, b.a.r0.a2.a.a(e2));
                    }
                }
                j(str, linkedList, linkedList2);
                BdLog.e("mixingVideoByVideo videoList length = " + list.size() + " cost = " + (System.currentTimeMillis() - currentTimeMillis));
                return new i(0, "");
            }
            return new i(10, TbadkCoreApplication.getInst().getString(R.string.illegal_argument));
        }
        return (i) invokeLLZ.objValue;
    }

    public final void j(String str, List<Track> list, List<Track> list2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, list, list2) == null) {
            Movie movie = new Movie();
            if (list2 != null && list2.size() > 0) {
                movie.addTrack(new AppendTrack((Track[]) list2.toArray(new Track[list2.size()])));
            }
            if (list != null && list.size() > 0) {
                movie.addTrack(new AppendTrack((Track[]) list.toArray(new Track[list.size()])));
            }
            Container build = new DefaultMp4Builder().build(movie);
            FileChannel channel = new RandomAccessFile(String.format(str, new Object[0]), "rw").getChannel();
            build.writeContainer(channel);
            channel.close();
        }
    }
}

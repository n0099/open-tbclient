package c.a.a1.t;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.a1.l.d.f;
import c.a.a1.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.googlecode.mp4parser.authoring.tracks.AACTrackImpl;
import com.googlecode.mp4parser.authoring.tracks.AppendTrack;
import com.googlecode.mp4parser.authoring.tracks.CroppedTrack;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public static Object a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements a.InterfaceC0029a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        public a(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb;
        }

        @Override // c.a.a1.s.a.InterfaceC0029a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (x.a) {
                    x.a.notifyAll();
                }
            }
        }

        @Override // c.a.a1.s.a.InterfaceC0029a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = this.a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",ffmpegerror i:");
                sb2.append(i2);
                sb2.append("i1");
                sb2.append(i3);
                sb2.append("msg:");
                sb2.append(obj != null ? obj.toString() : "");
                sb.append(sb2.toString());
                synchronized (x.a) {
                    x.a.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.a1.s.a.InterfaceC0029a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements a.InterfaceC0029a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        public b(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb;
        }

        @Override // c.a.a1.s.a.InterfaceC0029a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (x.a) {
                    x.a.notifyAll();
                }
            }
        }

        @Override // c.a.a1.s.a.InterfaceC0029a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = this.a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",ffmpegerror i:");
                sb2.append(i2);
                sb2.append("i1");
                sb2.append(i3);
                sb2.append("msg:");
                sb2.append(obj != null ? obj.toString() : "");
                sb.append(sb2.toString());
                synchronized (x.a) {
                    x.a.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.a1.s.a.InterfaceC0029a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1486159575, "Lc/a/a1/t/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1486159575, "Lc/a/a1/t/x;");
                return;
            }
        }
        a = new Object();
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Track track;
        Movie movie;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (FileUtils.isExists(str)) {
                try {
                    track = new AACTrackImpl(new FileDataSourceImpl(str));
                } catch (Exception unused) {
                    track = null;
                    try {
                        movie = MovieCreator.build(str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        movie = null;
                    }
                    if (movie == null) {
                        return -1L;
                    }
                    for (Track track2 : movie.getTracks()) {
                        if ("soun".equals(track2.getHandler())) {
                            track = track2;
                        }
                    }
                }
                if (track == null) {
                    return -1L;
                }
                return d(track);
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (FileUtils.checkFile(str) && !TextUtils.isEmpty(str2)) {
                if (FileUtils.checkFile(str2)) {
                    return str2;
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    for (Track track : MovieCreator.build(str).getTracks()) {
                        if (track.getHandler().equals("soun")) {
                            arrayList.add(track);
                        }
                    }
                    Movie movie = new Movie();
                    if (arrayList.size() > 0) {
                        movie.addTrack(new AppendTrack((Track[]) arrayList.toArray(new Track[arrayList.size()])));
                        Container build = new DefaultMp4Builder().build(movie);
                        try {
                            FileChannel channel = new RandomAccessFile(str2, "rw").getChannel();
                            build.writeContainer(channel);
                            channel.close();
                        } catch (Exception unused) {
                            c.e("getAudioFromVideo", "合拍提取音频失败1");
                            return "";
                        }
                    }
                    return str2;
                } catch (Exception unused2) {
                    c.e("getAudioFromVideo", "合拍提取音频失败2");
                    return "";
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static long d(Track track) {
        InterceptResult invokeL;
        TrackMetaData trackMetaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, track)) == null) {
            if (track == null || (trackMetaData = track.getTrackMetaData()) == null) {
                return 0L;
            }
            long duration = track.getDuration();
            long timescale = trackMetaData.getTimescale();
            if (duration <= 0 || timescale <= 0) {
                return 0L;
            }
            return (((float) duration) * 1000.0f) / ((float) timescale);
        }
        return invokeL.longValue;
    }

    public static long e(Track track, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{track, Double.valueOf(d2)})) == null) {
            long j2 = 0;
            if (track == null) {
                return 0L;
            }
            double d3 = 0.0d;
            TrackMetaData trackMetaData = track.getTrackMetaData();
            if (trackMetaData == null) {
                return 0L;
            }
            long timescale = trackMetaData.getTimescale();
            long[] sampleDurations = track.getSampleDurations();
            if (timescale > 0 && sampleDurations != null) {
                for (long j3 : sampleDurations) {
                    d3 += j3 / timescale;
                    if (d3 >= d2) {
                        break;
                    }
                    j2++;
                }
            }
            return j2;
        }
        return invokeCommon.longValue;
    }

    public static long f(String str) {
        InterceptResult invokeL;
        Movie movie;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (FileUtils.isExists(str)) {
                Track track = null;
                try {
                    try {
                        movie = MovieCreator.build(str);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        movie = null;
                    }
                    for (Track track2 : movie.getTracks()) {
                        if ("vide".equals(track2.getHandler())) {
                            track = track2;
                        }
                    }
                } catch (Exception unused) {
                }
                if (track == null) {
                    return -1L;
                }
                return d(track);
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public static boolean g(StringBuilder sb, String str, List<String> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, sb, str, list)) == null) {
            StringBuilder sb2 = new StringBuilder();
            c.a.a1.l.d.f.b(list, str, "", new a(sb2), true, false);
            synchronized (a) {
                try {
                    a.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            sb.append(sb2.toString());
            return TextUtils.isEmpty(sb2.toString());
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean h(StringBuilder sb, List<String> list, String str, c.a.a1.p.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(65544, null, sb, list, str, aVar)) != null) {
            return invokeLLLL.booleanValue;
        }
        boolean z = false;
        if (h.e(list)) {
            if (sb != null) {
                sb.append("原文件列表 inputFileList == null");
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (sb != null) {
                sb.append("mergeVideo操作，outputFile为空 ");
            }
            return false;
        } else {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (FileUtils.isExists(list.get(i2))) {
                    arrayList.add(list.get(i2));
                }
            }
            if (arrayList.size() < 1) {
                if (sb != null) {
                    sb.append("原文件列表为空或输出视频路径不合法");
                }
                return false;
            } else if (arrayList.size() == 1) {
                try {
                    return FileUtils.copyFile(list.get(0), str);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            } else {
                boolean g2 = g(sb, str, arrayList);
                long j2 = 0;
                if (g2) {
                    long j3 = 0;
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        j3 += n.a((String) arrayList.get(i3));
                    }
                    long a2 = j3 - n.a(str);
                    if (Math.abs(a2) >= 1000) {
                        sb.append("ffmpeg duration check error mp4Srcduration - mp4MixerDuration : ");
                        sb.append(a2);
                        g2 = false;
                    }
                }
                if (!g2 && (g2 = new c.a.a1.l.c(arrayList, str, aVar).b(sb))) {
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        j2 += n.a((String) arrayList.get(i4));
                    }
                    long a3 = j2 - n.a(str);
                    if (Math.abs(a3) >= 1000) {
                        sb.append("extractor duration check error mp4Srcduration - mp4MixerDuration : ");
                        sb.append(a3);
                        return z ? i(sb, arrayList, str) : z;
                    }
                }
                z = g2;
                if (z) {
                }
            }
        }
    }

    public static boolean i(StringBuilder sb, List<String> list, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, sb, list, str)) == null) {
            LinkedList<Movie> linkedList = new LinkedList();
            try {
                for (String str2 : list) {
                    linkedList.add(MovieCreator.build(str2));
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (Movie movie : linkedList) {
                    for (Track track : movie.getTracks()) {
                        if (track.getHandler().equals("soun")) {
                            arrayList2.add(track);
                        }
                        if (track.getHandler().equals("vide")) {
                            arrayList.add(track);
                        }
                    }
                }
                Movie movie2 = new Movie();
                if (arrayList2.size() > 0) {
                    movie2.addTrack(new AppendTrack((Track[]) arrayList2.toArray(new Track[arrayList2.size()])));
                }
                if (arrayList.size() > 0) {
                    movie2.addTrack(new AppendTrack((Track[]) arrayList.toArray(new Track[arrayList.size()])));
                }
                Container build = new DefaultMp4Builder().build(movie2);
                FileChannel channel = new RandomAccessFile(str, "rw").getChannel();
                build.writeContainer(channel);
                channel.close();
                return true;
            } catch (Exception e2) {
                if (sb != null) {
                    sb.append("mp4parser 录制视频拼接过程中发生异常:" + e2.getMessage());
                }
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean j(StringBuilder sb, String str, String str2, String str3, long j2, long j3) {
        InterceptResult invokeCommon;
        boolean l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{sb, str, str2, str3, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                if (sb != null) {
                    sb.append("音频合成原文件列表为空或输出视频路径不合法");
                }
                return false;
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" vDuration:");
                sb2.append(n.f(str2));
                sb2.append(" , aDuration:");
                sb2.append(n.f(str));
                c.a.a1.a.a("time_duration_error", sb2.toString(), null);
            } catch (Exception unused) {
            }
            long a2 = n.a(str2);
            if (k(sb, str, str2, str3) || (l = l(sb, str, str2, str3, j2))) {
                return true;
            }
            f.C0018f e2 = c.a.a1.l.d.f.e(str);
            if (e2 != null && "audio/mpeg".equals(e2.f1319d)) {
                String str4 = FileUtils.removeExtention(str) + "mp3toaac.aac";
                File file = new File(str4);
                long j4 = (j3 <= 0 || j3 - j2 > a2) ? a2 + j2 : j3;
                if (sb != null) {
                    sb.append(",startmp3ToAAC");
                }
                boolean l2 = c.a.a1.l.d.g.l(str, str4, j2, j4, sb);
                if (sb != null) {
                    sb.append(",mp3ToAACresult:" + l2);
                }
                if (!l2) {
                    if (file.exists()) {
                        file.delete();
                    }
                    return false;
                }
                l = l(sb, file.getAbsolutePath(), str2, str3, j2);
                if (file.exists()) {
                    file.delete();
                }
            }
            return l;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean k(StringBuilder sb, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, sb, str, str2, str3)) == null) {
            if (FileUtils.checkFile(str) && FileUtils.checkFile(str2)) {
                StringBuilder sb2 = new StringBuilder();
                if (sb != null) {
                    sb.append(",startmuxAudioVideobyFFmpeg");
                }
                c.a.a1.a.a("av_muxer_by_ffmpeg", "startmuxAudioVideobyFFmpeg", null);
                c.a.a1.l.d.f.m(str2, str, str3, new b(sb2));
                try {
                    synchronized (a) {
                        a.wait();
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (TextUtils.isEmpty(sb2.toString())) {
                    return true;
                }
                if (sb != null) {
                    sb.append(sb2.toString());
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00be A[Catch: Exception -> 0x0294, TryCatch #2 {Exception -> 0x0294, blocks: (B:31:0x00b1, B:33:0x00be, B:34:0x00ca, B:36:0x00d0, B:41:0x00e8, B:43:0x00ee, B:50:0x010f, B:52:0x014a, B:54:0x0157, B:57:0x0167, B:68:0x01a6, B:20:0x0077, B:21:0x0090, B:23:0x0096, B:25:0x009e, B:10:0x005d, B:5:0x000e, B:7:0x002e), top: B:105:0x000e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x028e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x029a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean l(StringBuilder sb, String str, String str2, String str3, long j2) {
        InterceptResult invokeCommon;
        StringBuilder sb2;
        StringBuilder sb3;
        Track track;
        ArrayList arrayList;
        long j3;
        long j4;
        long j5;
        long a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{sb, str, str2, str3, Long.valueOf(j2)})) != null) {
            return invokeCommon.booleanValue;
        }
        StringBuilder sb4 = new StringBuilder();
        char c2 = 0;
        try {
            try {
                long f2 = n.f(str);
                f.C0018f e2 = c.a.a1.l.d.f.e(str);
                sb4.append(" , 音频duration=");
                sb4.append(f2);
                sb4.append(" , 视频duration=");
                sb4.append(n.f(str2));
                if (e2 != null) {
                    sb4.append(" , 音频format : ");
                    sb4.append(" , bitWidth=");
                    sb4.append(e2.f1318c);
                    sb4.append(" , channelCount=");
                    sb4.append(e2.f1317b);
                    sb4.append(" , mime=");
                    sb4.append(e2.f1319d);
                    sb4.append(" , sampleRate=");
                    sb4.append(e2.a);
                }
            } catch (Exception e3) {
                sb4.append(m.g(e3));
            }
            Track track2 = null;
            try {
            } catch (Exception e4) {
                e = e4;
            }
            try {
                track = new AACTrackImpl(new FileDataSourceImpl(str));
            } catch (Exception e5) {
                e = e5;
                sb4.append(" ,aacTrack error ");
                sb4.append(e.toString());
                Track track3 = null;
                for (Track track4 : MovieCreator.build(str).getTracks()) {
                    if (track4 != null && "soun".equals(track4.getHandler())) {
                        track3 = track4;
                    }
                }
                track = track3;
                if (track != null) {
                }
            }
            if (track != null) {
                if (sb != null) {
                    sb.append(" mp4parser 音频合成没有找到aac aacTrack ");
                    sb.append(sb4.toString());
                }
                return false;
            }
            for (Track track5 : MovieCreator.build(str2).getTracks()) {
                if ("vide".equals(track5.getHandler())) {
                    track2 = track5;
                }
            }
            if (track2 == null) {
                if (sb != null) {
                    sb.append("mp4parser 音频合成 videoTracks == null");
                }
                return false;
            }
            Movie movie = new Movie();
            movie.addTrack(track2);
            long d2 = d(track2);
            long d3 = d(track);
            long j6 = d3 - j2;
            long j7 = j6 <= 0 ? d3 : j6;
            if (j7 <= 0) {
                if (sb != null) {
                    sb.append(" mp4parser 音频合成过程中发生异常: ");
                    sb.append(sb4.toString());
                    sb.append(" 音频可用时长异常");
                    sb.append(" 详细信息:");
                    sb.append("canUseAacDuration:" + j7 + ",aacDuration" + d3 + ",audioStartTimeS" + j2);
                }
                return false;
            }
            int i2 = 1;
            if (Math.abs(d2 - j7) < 100) {
                movie.addTrack(track);
            } else {
                int i3 = (d2 > j7 ? 1 : (d2 == j7 ? 0 : -1));
                if (i3 < 0) {
                    movie.addTrack(new AppendTrack(new CroppedTrack(track, e(track, (j2 * 1.0d) / 1000.0d), e(track, ((j2 + d2) * 1.0d) / 1000.0d))));
                } else if (i3 > 0) {
                    try {
                        ArrayList arrayList2 = new ArrayList();
                        long j8 = 0;
                        while (j8 < d2) {
                            long j9 = d2 - j8;
                            if (j9 >= j7) {
                                if (j2 == 0) {
                                    long j10 = j7;
                                    Track[] trackArr = new Track[i2];
                                    trackArr[c2] = track;
                                    arrayList2.add(new AppendTrack(trackArr));
                                    j3 = j10;
                                    sb3 = sb4;
                                    arrayList = arrayList2;
                                    j4 = d3;
                                    j5 = d2;
                                } else {
                                    j5 = d2;
                                    Track[] trackArr2 = new Track[1];
                                    sb3 = sb4;
                                    arrayList = arrayList2;
                                    j3 = j7;
                                    j4 = d3;
                                    try {
                                        trackArr2[0] = new CroppedTrack(track, e(track, (j2 * 1.0d) / 1000.0d), e(track, (d3 * 1.0d) / 1000.0d));
                                        arrayList.add(new AppendTrack(trackArr2));
                                    } catch (Exception e6) {
                                        e = e6;
                                        sb2 = sb;
                                        if (sb2 != null) {
                                            sb2.append(" mp4parser 音频合成过程中发生异常-0: ");
                                            sb2.append(",logBuilder: ");
                                            sb2.append(sb3.toString());
                                            sb2.append(",详细信息-0:");
                                            sb2.append(m.g(e));
                                        }
                                        e.printStackTrace();
                                        return false;
                                    }
                                }
                                j8 += j3;
                            } else {
                                sb3 = sb4;
                                arrayList = arrayList2;
                                j3 = j7;
                                j4 = d3;
                                j5 = d2;
                                arrayList.add(new AppendTrack(new CroppedTrack(track, e(track, (j2 * 1.0d) / 1000.0d), e(track, ((j2 + j9) * 1.0d) / 1000.0d))));
                                j8 += j9;
                            }
                            arrayList2 = arrayList;
                            d2 = j5;
                            sb4 = sb3;
                            j7 = j3;
                            d3 = j4;
                            c2 = 0;
                            i2 = 1;
                        }
                        sb3 = sb4;
                        ArrayList arrayList3 = arrayList2;
                        movie.addTrack(new AppendTrack((Track[]) arrayList3.toArray(new Track[arrayList3.size()])));
                        Container build = new DefaultMp4Builder().build(movie);
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(str3));
                        build.writeContainer(fileOutputStream.getChannel());
                        fileOutputStream.close();
                        a2 = n.a(str3);
                        if (a2 > 0) {
                            if (sb != null) {
                                sb.append(", mp4parser afterDuration:");
                                sb.append(a2);
                                return false;
                            }
                            return false;
                        }
                        return true;
                    } catch (Exception e7) {
                        e = e7;
                        sb3 = sb4;
                        sb2 = sb;
                        if (sb2 != null) {
                        }
                        e.printStackTrace();
                        return false;
                    }
                }
            }
            sb3 = sb4;
            Container build2 = new DefaultMp4Builder().build(movie);
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str3));
            build2.writeContainer(fileOutputStream2.getChannel());
            fileOutputStream2.close();
            a2 = n.a(str3);
            if (a2 > 0) {
            }
        } catch (Exception e8) {
            e = e8;
            sb2 = sb;
            sb3 = sb4;
            if (sb2 != null) {
            }
            e.printStackTrace();
            return false;
        }
    }
}

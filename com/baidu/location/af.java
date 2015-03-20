package com.baidu.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.baidu.tbadk.TbConfig;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
class af implements SensorEventListener, a0, com.baidu.location.b {
    private static af kK;
    private Sensor kB;
    private Sensor kH;
    private Handler kJ;
    private SensorManager kO;
    private final int kR = 1;
    private final int kC = 2;
    private boolean kI = false;
    private boolean kG = false;
    private boolean kE = false;
    private boolean kD = false;
    private StringBuffer kP = null;
    private StringBuffer kN = null;
    private Runnable kQ = null;
    private Runnable kA = null;
    private int kM = 0;
    private int kF = 0;
    private boolean kL = false;

    /* loaded from: classes.dex */
    class a {

        /* renamed from: if  reason: not valid java name */
        public boolean f42if = false;

        /* renamed from: do  reason: not valid java name */
        StringBuffer f41do = null;

        a() {
        }

        public void a() {
        }

        /* renamed from: do  reason: not valid java name */
        public void m150do() {
        }

        /* renamed from: if  reason: not valid java name */
        public void m151if() {
        }
    }

    /* loaded from: classes.dex */
    class b {
        public b() {
        }
    }

    private af() {
        try {
            this.kO = (SensorManager) f.getServiceContext().getSystemService("sensor");
            this.kB = this.kO.getDefaultSensor(1);
            this.kH = this.kO.getDefaultSensor(2);
        } catch (Exception e) {
        }
        this.kJ = new Handler();
    }

    public static af c0() {
        if (kK == null) {
            kK = new af();
        }
        return kK;
    }

    private String c1() {
        String[] strArr;
        String d = d(2);
        for (String str : new String[]{"lbaca.dat", "lbacb.dat", "lbacc.dat", "lbacd.dat"}) {
            if (!new File(d + File.separator + str).exists()) {
                return d + File.separator + str;
            }
        }
        return null;
    }

    private boolean c4() {
        boolean z = false;
        String c5 = c5();
        if (c5 != null) {
            try {
                File file = new File(c5);
                if (file.exists()) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(4L);
                    long readLong = randomAccessFile.readLong();
                    int readInt = randomAccessFile.readInt();
                    if (randomAccessFile.readInt() == 3321) {
                        long currentTimeMillis = System.currentTimeMillis() - readLong;
                        if (currentTimeMillis < 0 || currentTimeMillis > 86400000) {
                            randomAccessFile.seek(4L);
                            randomAccessFile.writeLong(System.currentTimeMillis());
                            randomAccessFile.writeInt(0);
                            randomAccessFile.close();
                            z = true;
                        } else if (readInt > 96000) {
                            randomAccessFile.close();
                        } else {
                            randomAccessFile.close();
                            z = true;
                        }
                    } else {
                        m142if(randomAccessFile, 0);
                        randomAccessFile.close();
                        z = true;
                    }
                } else {
                    file.createNewFile();
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                    m142if(randomAccessFile2, 0);
                    randomAccessFile2.close();
                    z = true;
                }
            } catch (Exception e) {
            }
        }
        return z;
    }

    private String c5() {
        String d = d(1);
        if (d == null) {
            return null;
        }
        String str = d + File.separator + "lscts.dat";
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                m142if(randomAccessFile, 0);
                randomAccessFile.close();
            } catch (Exception e) {
                return null;
            }
        }
        return str;
    }

    private void cQ() {
        if (this.kO == null || this.kH == null || this.kD) {
            return;
        }
        try {
            this.kO.registerListener(this, this.kH, 2, this.kJ);
            this.kD = true;
        } catch (Exception e) {
        }
    }

    private void cR() {
        if (this.kD) {
            try {
                this.kO.unregisterListener(this, this.kH);
                this.kD = false;
            } catch (Exception e) {
            }
        }
    }

    private void cS() {
        if (this.kO == null || this.kB == null || this.kE) {
            return;
        }
        try {
            this.kO.registerListener(this, this.kB, 2, this.kJ);
            this.kE = true;
        } catch (Exception e) {
        }
    }

    private void cT() {
        if (this.kG || this.kI) {
            cS();
        }
        if (this.kG) {
            cQ();
        }
    }

    private String cV() {
        String[] strArr;
        String d = d(1);
        for (String str : new String[]{"lmibaca.dat", "lmibacb.dat"}) {
            if (!new File(d + File.separator + str).exists()) {
                return d + File.separator + str;
            }
        }
        return null;
    }

    private void cW() {
        if (this.kE) {
            try {
                this.kO.unregisterListener(this, this.kB);
                this.kE = false;
            } catch (Exception e) {
            }
        }
    }

    private void cX() {
        this.kG = true;
        this.kN = new StringBuffer(8192);
        cT();
        this.kQ = new Runnable() { // from class: com.baidu.location.af.3
            @Override // java.lang.Runnable
            public void run() {
                af.this.c3();
            }
        };
        this.kJ.postDelayed(this.kQ, TbConfig.USE_TIME_INTERVAL);
    }

    private void cZ() {
        if (this.kG) {
            return;
        }
        if (this.kI) {
            cR();
            return;
        }
        cR();
        cW();
        this.kM = 0;
        this.kF = 0;
    }

    private String d(int i) {
        String str;
        String m266goto = c.m266goto();
        if (m266goto == null) {
            return null;
        }
        if (i == 1) {
            str = m266goto + File.separator + "llmis1";
        } else if (i != 2) {
            return null;
        } else {
            str = m266goto + File.separator + "llmis2";
        }
        File file = new File(str);
        if (file.exists()) {
            return str;
        }
        try {
            if (file.mkdirs()) {
                return str;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m139do(StringBuffer stringBuffer) {
        if (!this.kG || this.kN == null) {
            return;
        }
        m145if(this.kN, stringBuffer, h(2));
    }

    private void e(int i) {
        String c5 = c5();
        if (c5 == null) {
            return;
        }
        try {
            File file = new File(c5);
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                randomAccessFile.readLong();
                int readInt2 = randomAccessFile.readInt();
                if (randomAccessFile.readInt() == 3321 && readInt == 3321) {
                    randomAccessFile.seek(12L);
                    randomAccessFile.writeInt(readInt2 + i);
                } else {
                    m142if(randomAccessFile, 48000 + i);
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    private String h(int i) {
        String d = d(i);
        if (d == null) {
            return null;
        }
        if (i == 2) {
            return d + File.separator + "lbacz.dat";
        }
        if (i == 1) {
            return d + File.separator + "lmibacz.dat";
        }
        return null;
    }

    /* renamed from: if  reason: not valid java name */
    private void m142if(RandomAccessFile randomAccessFile, int i) {
        try {
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(3321);
            randomAccessFile.writeLong(System.currentTimeMillis());
            randomAccessFile.writeInt(i);
            randomAccessFile.writeInt(3321);
        } catch (Exception e) {
        }
    }

    /* renamed from: if  reason: not valid java name */
    private void m143if(StringBuffer stringBuffer) {
        if (!this.kI || this.kP == null) {
            return;
        }
        m145if(this.kP, stringBuffer, h(1));
    }

    /* renamed from: if  reason: not valid java name */
    private void m144if(StringBuffer stringBuffer, File file) {
        boolean z = true;
        if (file.exists()) {
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(file, true)));
                for (int i = 0; i < 3; i++) {
                    try {
                        gZIPOutputStream.write(stringBuffer.toString().getBytes());
                    } catch (Exception e) {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                }
                gZIPOutputStream.close();
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    private void m145if(StringBuffer stringBuffer, StringBuffer stringBuffer2, String str) {
        if (stringBuffer.length() + stringBuffer2.length() < 8190) {
            stringBuffer.append(stringBuffer2);
            return;
        }
        File file = new File(str);
        e(stringBuffer.length());
        m144if(stringBuffer, file);
        this.kL = true;
        stringBuffer.delete(0, stringBuffer.length());
        stringBuffer.append(stringBuffer2);
    }

    /* renamed from: if  reason: not valid java name */
    private boolean m146if(File file) {
        try {
            file.createNewFile();
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("C");
            stringBuffer.append("\t");
            stringBuffer.append(Jni.j(a2.cC().cB()));
            stringBuffer.append("\n");
            m144if(stringBuffer, file);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: if  reason: not valid java name */
    private boolean m147if(File file, int i) {
        String str = null;
        if (i == 2) {
            str = c1();
        } else if (i == 1) {
            str = cV();
        }
        if (str == null) {
            return false;
        }
        return file.renameTo(new File(str));
    }

    /* renamed from: void  reason: not valid java name */
    private boolean m148void(int i) {
        String h = h(i);
        if (h == null) {
            return false;
        }
        if (i == 2) {
            File file = new File(h);
            if (file.exists()) {
                if (file.length() <= 30720) {
                    return true;
                }
                if (!m147if(file, i)) {
                    return false;
                }
            }
            File file2 = new File(h);
            if (file2.exists()) {
                return false;
            }
            try {
                return m146if(file2);
            } catch (Exception e) {
                return false;
            }
        } else if (i == 1 && c4()) {
            File file3 = new File(h);
            if (file3.exists()) {
                if (file3.length() <= 30720) {
                    return true;
                }
                if (!m147if(file3, i)) {
                    return false;
                }
            }
            File file4 = new File(h);
            if (file4.exists()) {
                return false;
            }
            try {
                return m146if(file4);
            } catch (Exception e2) {
                return false;
            }
        } else {
            return false;
        }
    }

    public void c2() {
        this.kI = false;
        if ((this.kP != null && this.kP.length() > 3800) || this.kL) {
            File file = new File(h(1));
            e(this.kP.length());
            m144if(this.kP, file);
            this.kL = false;
        }
        this.kP = null;
        cZ();
    }

    public void c3() {
        this.kG = false;
        if (this.kN != null && this.kN.length() > 3800) {
            m144if(this.kN, new File(h(2)));
        }
        this.kN = null;
        cZ();
    }

    public String cU() {
        String[] strArr;
        String d = d(1);
        try {
            for (String str : new String[]{"lmibaca.dat", "lmibacb.dat", "lmibacz.dat"}) {
                File file = new File(d + File.separator + str);
                if (file.exists()) {
                    if (file.length() > 92160) {
                        file.delete();
                    } else if (file.length() >= 4096) {
                        if (str.equals("lmibacz.dat") && this.kI) {
                            return null;
                        }
                        return d + File.separator + str;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public void cY() {
        this.kJ.post(new Runnable() { // from class: com.baidu.location.af.2
            @Override // java.lang.Runnable
            public void run() {
                af.this.kJ.removeCallbacks(af.this.kQ);
                af.this.kJ.removeCallbacks(af.this.kA);
                af.this.c2();
                af.this.c3();
            }
        });
    }

    /* renamed from: long  reason: not valid java name */
    public void m149long(int i) {
        if (!this.kI && m148void(1)) {
            StringBuffer stringBuffer = new StringBuffer(128);
            this.kI = true;
            this.kP = new StringBuffer(8192);
            stringBuffer.append("T1");
            stringBuffer.append("\t");
            stringBuffer.append(i);
            stringBuffer.append("\n");
            m143if(stringBuffer);
            cT();
            this.kA = new Runnable() { // from class: com.baidu.location.af.1
                @Override // java.lang.Runnable
                public void run() {
                    af.this.c2();
                }
            };
            this.kJ.postDelayed(this.kA, 8000L);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        StringBuffer stringBuffer = new StringBuffer(256);
        if (type == 1) {
            this.kM++;
            stringBuffer.append("A");
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[0]);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[1]);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[2]);
            if (this.kM == 1) {
                stringBuffer.append("\t");
                stringBuffer.append(sensorEvent.timestamp);
            }
            if (this.kM >= 14) {
                this.kM = 0;
            }
            stringBuffer.append("\n");
            m139do(stringBuffer);
            m143if(stringBuffer);
        }
        if (type == 2) {
            this.kF++;
            stringBuffer.append("M");
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[0]);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[1]);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[2]);
            if (this.kF == 1) {
                stringBuffer.append("\t");
                stringBuffer.append(sensorEvent.timestamp);
            }
            if (this.kF > 13) {
                this.kF = 0;
            }
            stringBuffer.append("\n");
            m139do(stringBuffer);
        }
    }
}

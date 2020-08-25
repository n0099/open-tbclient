package com.baidu.platform.comapi.longlink;

import com.baidu.platform.comapi.exception.ComInitException;
import com.baidu.platform.comapi.exception.InvalidComException;
import com.baidu.platform.comjni.base.longlink.NALongLink;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class LongLinkClient {
    private int a;
    private long b;
    private int c;

    private LongLinkClient(long j) {
        this.b = j;
    }

    private LongLinkClient(long j, int i) {
        this.b = j;
        this.a = i;
    }

    public static LongLinkClient create() throws ComInitException {
        long create = NALongLink.create();
        if (create != 0) {
            return new LongLinkClient(create);
        }
        throw new ComInitException("LongLink Component created failed!");
    }

    public static LongLinkClient create(int i) throws ComInitException {
        long create = NALongLink.create();
        if (create != 0) {
            return new LongLinkClient(create, i);
        }
        throw new ComInitException("LongLink Component created failed!");
    }

    public synchronized int getRequestId() {
        return this.c;
    }

    public boolean init(String str, String str2) throws InvalidComException {
        if (isValid()) {
            return NALongLink.init(this.b, str, str2);
        }
        throw new InvalidComException();
    }

    public boolean isValid() {
        return this.b != 0;
    }

    public synchronized boolean register(LongLinkDataCallback longLinkDataCallback) throws InvalidComException {
        if (!isValid()) {
            throw new InvalidComException();
        }
        return NALongLink.register(this.b, this.a, longLinkDataCallback);
    }

    public int release() {
        if (!isValid() || NALongLink.release(this.b) > 0) {
            return -1;
        }
        this.b = 0L;
        return -1;
    }

    public synchronized ELongLinkStatus sendData(byte[] bArr) throws InvalidComException {
        ELongLinkStatus eLongLinkStatus;
        if (!isValid()) {
            throw new InvalidComException();
        }
        this.c++;
        eLongLinkStatus = ELongLinkStatus.values()[NALongLink.sendData(this.b, this.a, this.c, bArr)];
        eLongLinkStatus.setRequestId(this.c);
        return eLongLinkStatus;
    }

    public synchronized ELongLinkStatus sendFileData(String str, ArrayList<LongLinkFileData> arrayList) throws InvalidComException {
        ELongLinkStatus eLongLinkStatus;
        if (!isValid()) {
            throw new InvalidComException();
        }
        this.c++;
        eLongLinkStatus = ELongLinkStatus.values()[NALongLink.sendFileData(this.b, this.a, this.c, str, arrayList)];
        eLongLinkStatus.setRequestId(this.c);
        return eLongLinkStatus;
    }

    public void setModuleId(int i) {
        this.a = i;
    }

    public boolean start() throws InvalidComException {
        if (isValid()) {
            return NALongLink.start(this.b);
        }
        throw new InvalidComException();
    }

    public void stop() throws InvalidComException {
        if (!isValid()) {
            throw new InvalidComException();
        }
        NALongLink.stop(this.b);
    }

    public synchronized boolean unRegister(LongLinkDataCallback longLinkDataCallback) throws InvalidComException {
        if (!isValid()) {
            throw new InvalidComException();
        }
        return NALongLink.unRegister(this.b, this.a, longLinkDataCallback);
    }
}

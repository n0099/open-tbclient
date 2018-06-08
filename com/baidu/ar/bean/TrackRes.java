package com.baidu.ar.bean;

import java.util.List;
/* loaded from: classes3.dex */
public class TrackRes {
    private List<f> a;
    private TipBean b;
    private d c;
    private e d;
    private b e;

    public TrackRes() {
    }

    public TrackRes(TrackRes trackRes) {
        if (trackRes.getTargetBeanList() != null && trackRes.getTargetBeanList().size() != 0) {
            this.a = trackRes.getTargetBeanList();
        }
        if (trackRes.getTipBean() != null) {
            if (this.b == null) {
                this.b = trackRes.getTipBean();
            } else {
                this.b = this.b.clone(trackRes.getTipBean());
            }
        }
    }

    public b getPaddle() {
        return this.e;
    }

    public d getService() {
        return this.c;
    }

    public e getSlamModel() {
        return this.d;
    }

    public List<f> getTargetBeanList() {
        return this.a;
    }

    public TipBean getTipBean() {
        return this.b;
    }

    public void setPaddle(b bVar) {
        this.e = bVar;
    }

    public void setService(d dVar) {
        this.c = dVar;
    }

    public void setSlamModel(e eVar) {
        this.d = eVar;
    }

    public void setTargetBeanList(List<f> list) {
        this.a = list;
    }

    public void setTipBean(TipBean tipBean) {
        this.b = tipBean;
    }
}

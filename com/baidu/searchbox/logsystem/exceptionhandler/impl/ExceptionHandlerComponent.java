package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.hl1;
import com.baidu.tieba.jl1;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    @Inject
    public jl1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        hl1 b = hl1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}

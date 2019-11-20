package com.baidu.swan.apps.install;

import android.os.Bundle;
import com.baidu.swan.apps.install.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes2.dex */
public class c extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final File aRE;

    public c(File file) {
        super("dump");
        this.aRE = file;
    }

    @Override // com.baidu.swan.apps.install.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.v.c.a fF = com.baidu.swan.apps.v.c.a.fF(bundle.getString("launch_id"));
        fF.KX().fI("DumpFileProcessor").dD(1);
        try {
            try {
                a((ReadableByteChannel) sourceChannel);
                fF.as("DumpFileProcessor", "done");
                return true;
            } catch (IOException e) {
                fF.as("DumpFileProcessor", "done with exception: " + e.toString());
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.an.b.b.a(sourceChannel);
                com.baidu.swan.c.a.b(null);
                return false;
            }
        } finally {
            com.baidu.swan.apps.an.b.b.a(sourceChannel);
            com.baidu.swan.c.a.b(null);
        }
    }

    private void a(ReadableByteChannel readableByteChannel) throws IOException {
        WritableByteChannel newChannel = Channels.newChannel(new FileOutputStream(this.aRE, false));
        ByteBuffer allocate = ByteBuffer.allocate(com.baidu.swan.apps.core.pms.a.Gg());
        while (readableByteChannel.read(allocate) != -1) {
            allocate.flip();
            newChannel.write(allocate);
            allocate.clear();
        }
    }
}
